package com.example.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.size
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import androidx.navigation.NavGraph
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.home.databinding.FragmentHomeBinding
import com.example.task.Task
import com.example.views.navigation.AddTaskFragmentRouter
import com.example.views.navigation.ExpandedTaskFragmentRouter
import com.example.views.navigation.HomeFragmentRouter
import com.example.views.navigation.SettingsFragmentRouter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import javax.inject.Inject

@AndroidEntryPoint
class HomeFragment : Fragment(), HomeBindingAdapter.OnItemClickListener{

    companion object {
        const val TAG = "HomeFragment"
    }

    private val args: HomeFragmentArgs by navArgs()
    private lateinit var localController: NavController

    @Inject
    lateinit var settingsFragmentRouter: SettingsFragmentRouter

    @Inject
    lateinit var addTaskFragmentRouter: AddTaskFragmentRouter

    @Inject
    lateinit var expandedTaskFragmentRouter: ExpandedTaskFragmentRouter

    private val homeViewModel: HomeViewModel by viewModels()

    private lateinit var fragmentHomeBinding: FragmentHomeBinding

    private var position: Int = 0

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentHomeBinding = FragmentHomeBinding.inflate(inflater, container, false)

        return fragmentHomeBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val taskData = args.taskKey
        if(taskData != null) {
            runBlocking {
                homeViewModel.addNewTask(taskData)
            }
        }
        homeViewModel.emitInitialViewState()
        Log.d(TAG, "New task data: $taskData")
        localController = this.findNavController()

        with(fragmentHomeBinding) {
            viewModel = homeViewModel
            viewState = viewModel?.viewState?.value?.peekContent()
            executePendingBindings()
        }

        homeViewModel.viewEvent.observe(viewLifecycleOwner) {
            when(it.getContentIfNotHandled()) {
                is HomeViewEvent.ExpandTask -> {
                    Log.d(TAG, "navigating to expanded task")
                    navigateExpandedTaskScreen()
                }
                is HomeViewEvent.DeleteTask -> {
                    deleteTask()
                }
                is HomeViewEvent.CompleteTask -> {
                    completeTask()
                }
                is HomeViewEvent.AddTask -> {
                    Log.d(TAG, "navigating to add task")
                    navigateToAddTaskScreen()
                }
                is HomeViewEvent.Settings -> {
                    Log.d(TAG, "navigating to settings")
                    navigateToSettingsScreen()
                }
                is HomeViewEvent.Filter -> {
                    Log.d(TAG, "navigating to filter")
                    navigateToFilterScreen()
                }
                is HomeViewEvent.RemoveCompleteTask -> {
                    revertCompleteTask()
                }
                else -> {}
            }
        }

        homeViewModel.viewState.observe(viewLifecycleOwner) {
            val viewState = it.peekContent()
            fragmentHomeBinding.taskRv.apply {
                adapter = HomeBindingAdapter(viewState.tasks)
            }
        }
    }

    private fun navigateToFilterScreen() {

    }

    private fun navigateToSettingsScreen() {
        settingsFragmentRouter.show(localController)
    }

    private fun navigateExpandedTaskScreen() {
        val task: Task = homeViewModel.viewState.value?.peekContent()?.tasks?.get(position)!!
        expandedTaskFragmentRouter.show(localController, task)
    }

    private fun completeTask() {
        //Update db
        val task: Task? = homeViewModel.viewState.value?.peekContent()?.tasks?.get(position)
        homeViewModel.updateCompleteTaskValue(task, true)
        //Update ui
        fragmentHomeBinding.taskRv.adapter?.notifyItemChanged(position)
    }

    private fun revertCompleteTask() {
        //Remove line through task title
        val task: Task? = homeViewModel.viewState.value?.peekContent()?.tasks?.get(position)
        homeViewModel.updateCompleteTaskValue(task, false)
        fragmentHomeBinding.taskRv.adapter?.notifyItemChanged(position)
    }

    private fun navigateToAddTaskScreen() {
        addTaskFragmentRouter.show(localController)
    }

    private fun deleteTask() {
        //Update db
        homeViewModel.deleteTask(homeViewModel.viewState.value?.peekContent()?.tasks?.get(position))

        //Update ui
        fragmentHomeBinding.taskRv.adapter?.notifyItemRemoved(position)
        homeViewModel.viewState.value?.peekContent()?.tasks?.size?.let {
            fragmentHomeBinding.taskRv.adapter?.notifyItemRangeChanged(
                position,
                it
            )
        }
    }

    override fun onItemClick(position: Int) {
        this.position = position
    }
}