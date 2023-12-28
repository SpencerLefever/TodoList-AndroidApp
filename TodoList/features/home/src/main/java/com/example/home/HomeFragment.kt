package com.example.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.home.databinding.FragmentHomeBinding
import com.example.task.Task

class HomeFragment : Fragment(), HomeBindingAdapter.OnItemClickListener{

    companion object {
        const val TAG = "HomeFragment"
    }

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
        //Update db
        val task: com.example.task.Task? = homeViewModel.viewState.value?.peekContent()?.tasks?.get(position)
        homeViewModel.updateCompleteTaskValue(task, true)
        //Update ui
        fragmentHomeBinding.taskRv.adapter?.notifyItemChanged(position)
    }

    private fun revertCompleteTask() {
        //Remove line through task title
        val task: com.example.task.Task? = homeViewModel.viewState.value?.peekContent()?.tasks?.get(position)
        homeViewModel.updateCompleteTaskValue(task, false)
        fragmentHomeBinding.taskRv.adapter?.notifyItemChanged(position)
    }

    private fun navigateToAddTaskScreen() {

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