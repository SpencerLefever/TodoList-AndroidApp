package com.example.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import androidx.navigation.NavGraph
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.navArgs
import com.example.home.databinding.FragmentHomeBinding
import com.example.task.Task
import com.example.views.navigation.AddTaskFragmentRouter
import com.example.views.navigation.ExpandedTaskFragmentRouter
import com.example.views.navigation.HomeFragmentRouter
import com.example.views.navigation.SettingsFragmentRouter
import kotlinx.coroutines.withContext
import javax.inject.Inject

class HomeFragment : Fragment(), HomeBindingAdapter.OnItemClickListener{

    companion object {
        const val TAG = "HomeFragment"
    }

    private val args: HomeFragmentArgs by navArgs()
    private lateinit var localController: NavController
    private lateinit var navGraph: NavGraph

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
        val localNavHost =
            childFragmentManager.findFragmentById(com.example.views.R.id.fragment_nav_host) as NavHostFragment
        localController = localNavHost.navController
        val graphInflater = localNavHost.navController.navInflater
        navGraph = graphInflater.inflate(R.navigation.nav_home_graph)
        navGraph.setStartDestination(R.id.homeFragment)
        localController.setGraph(navGraph, null)

        with(fragmentHomeBinding) {
            viewModel = homeViewModel
            viewState = viewModel?.viewState?.value?.peekContent()
            executePendingBindings()
        }

        homeViewModel.viewEvent.observe(viewLifecycleOwner) {
            when(it.getContentIfNotHandled()) {
                is HomeViewEvent.ExpandTask -> {
                    navigateExpandedTaskScreen()
                }
                is HomeViewEvent.DeleteTask -> {
                    deleteTask()
                }
                is HomeViewEvent.CompleteTask -> {
                    completeTask()
                }
                is HomeViewEvent.AddTask -> {
                    navigateToAddTaskScreen()
                }
                is HomeViewEvent.Settings -> {
                    navigateToSettingsScreen()
                }
                is HomeViewEvent.Filter -> {
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
                val homeBindingAdapter = HomeBindingAdapter(
                    context,
                    viewState
                )
                adapter = homeBindingAdapter
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