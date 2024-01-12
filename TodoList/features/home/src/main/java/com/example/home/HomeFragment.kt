package com.example.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.content.res.AppCompatResources
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.home.databinding.FragmentHomeBinding
import com.example.home.databinding.TaskLayoutBinding
import com.example.task.Task
import com.example.views.navigation.AddTaskFragmentRouter
import com.example.views.navigation.ExpandedTaskFragmentRouter
import com.example.views.navigation.SettingsFragmentRouter
import com.google.android.flexbox.FlexboxLayout
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

@AndroidEntryPoint
class HomeFragment : Fragment() {

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

        configureFlexbox()
        homeViewModel.emitInitialViewState()
        Log.d(TAG, "New task data: $taskData")
        Log.d(TAG, "First task: ${homeViewModel.viewState.value?.peekContent()?.tasks?.get(0)}")
        localController = this.findNavController()

        with(fragmentHomeBinding) {
            viewModel = homeViewModel
            viewState = viewModel?.viewState?.value?.peekContent()
            executePendingBindings()
        }

        homeViewModel.viewEvent.observe(viewLifecycleOwner) {
            when(it.getContentIfNotHandled()) {
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
                else -> {}
            }
        }

        homeViewModel.viewState.observe(viewLifecycleOwner) {
            val viewState = it.peekContent()
            fragmentHomeBinding.taskRv.apply {
                val mAdapter = HomeBindingAdapter(viewState, requireContext())
                mAdapter.setDeleteOnClickListener(
                    object: HomeBindingAdapter.OnDeleteClickListener {
                        override fun onClick(position: Int) {
                            deleteTask(position)
                        }
                    }
                )
                mAdapter.setCompleteOnClickListener(
                    object: HomeBindingAdapter.OnCompleteClickListener {
                        override fun onClick(position: Int) {
                            completeTask(position)
                        }
                    }
                )
                mAdapter.setExpandeOnClickListener(
                    object: HomeBindingAdapter.OnExpandClickListener {
                        override fun onClick(position: Int) {
                            navigateExpandedTaskScreen(position)
                        }
                    }
                )
                adapter = mAdapter
            }
        }
    }

    private fun navigateToFilterScreen() {

    }

    private fun navigateToSettingsScreen() {
        settingsFragmentRouter.show(localController)
    }

    private fun navigateExpandedTaskScreen(position: Int) {
        val task: Task = homeViewModel.viewState.value?.peekContent()?.tasks?.get(position)!!
        expandedTaskFragmentRouter.show(localController, task)
    }

    private fun completeTask(position: Int) {
        //Update db
        val task: Task? = homeViewModel.viewState.value?.peekContent()?.tasks?.get(position)
        runBlocking {
            Log.d(TAG, "Changing complete status to: ${task?.completed?.not()}")
            homeViewModel.updateCompleteTaskValue(task, task?.completed?.not())
        }
        val holder = fragmentHomeBinding.taskRv.findViewHolderForAdapterPosition(position) as HomeBindingAdapter.HomeViewHolder
        if(holder.taskCheckBox.isChecked) {
            holder.taskTitle.foreground = AppCompatResources.getDrawable(requireContext(), com.example.common_libs.R.drawable.strikethrough_text)
        } else {
            holder.taskTitle.foreground = null
        }
    }

    private fun navigateToAddTaskScreen() {
        addTaskFragmentRouter.show(localController)
    }

    private fun deleteTask(position: Int) {
        //Update db
        runBlocking {
            homeViewModel.deleteTask(homeViewModel.viewState.value?.peekContent()?.tasks?.get(position))
        }

        //Update ui
        fragmentHomeBinding.taskRv.adapter?.notifyItemRemoved(position)
        homeViewModel.viewState.value?.peekContent()?.tasks?.size?.let {
            fragmentHomeBinding.taskRv.adapter?.notifyItemRangeChanged(
                position,
                it
            )
        }
    }

    private fun configureFlexbox() {
        configureTaskHeaderLayout()
    }

    private fun configureTaskHeaderLayout() {
        val taskHeaderLayoutParams = FlexboxLayout.LayoutParams(
            FlexboxLayout.LayoutParams.WRAP_CONTENT,
            FlexboxLayout.LayoutParams.WRAP_CONTENT
        )
        taskHeaderLayoutParams.isWrapBefore = true
        taskHeaderLayoutParams.marginStart = 15
        fragmentHomeBinding.tasksHeader.layoutParams = taskHeaderLayoutParams
    }

}