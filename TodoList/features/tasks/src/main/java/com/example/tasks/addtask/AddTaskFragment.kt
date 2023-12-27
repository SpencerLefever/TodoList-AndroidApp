package com.example.tasks.addtask

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.tasks.databinding.FragmentAddTaskBinding

class AddTaskFragment : Fragment() {

    companion object {
        const val TAG = "AddTaskFragment"
    }

    private val addTaskViewModel: AddTaskViewModel by viewModels()

    private lateinit var fragmentAddTaskBinding: FragmentAddTaskBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        fragmentAddTaskBinding = FragmentAddTaskBinding.inflate(inflater, container, false)

        return fragmentAddTaskBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(fragmentAddTaskBinding) {
            viewModel = addTaskViewModel
            viewState = viewModel?.viewState?.value?.peekContent()
            executePendingBindings()
        }

        addTaskViewModel.viewEvent.observe(viewLifecycleOwner) {
            when(it.getContentIfNotHandled()) {
                is AddTaskViewEvent.Close -> {
                    navigateToHomeScreen()
                }
                is AddTaskViewEvent.Save -> {
                    saveTask()
                    navigateToHomeScreen()
                }
                else -> {}
            }
        }
    }

    private fun navigateToHomeScreen() {

    }

    private fun saveTask() {

    }
}