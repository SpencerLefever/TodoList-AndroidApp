package com.example.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.home.databinding.FragmentHomeBinding
import com.example.tasks.Task

class HomeFragment : Fragment() {

    companion object {
        const val TAG = "HomeFragment"
    }

    private val homeViewModel: HomeViewModel by viewModels()

    private lateinit var fragmentHomeBinding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentHomeBinding = FragmentHomeBinding.inflate(inflater, container, false)

        return fragmentHomeBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

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

    }

    private fun navigateExpandedTaskScreen() {

    }

    private fun completeTask() {
        //Add line through task title

    }

    private fun revertCompleteTask() {
        //Remove line through task title
    }

    private fun navigateToAddTaskScreen() {

    }

    private fun deleteTask() {
        val task: Task =
        homeViewModel.deleteTask(task)
    }
}