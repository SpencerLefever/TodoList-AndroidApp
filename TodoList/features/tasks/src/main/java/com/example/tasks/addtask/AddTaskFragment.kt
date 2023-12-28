package com.example.tasks.addtask

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import androidx.core.view.get
import androidx.core.view.size
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import androidx.navigation.NavGraph
import androidx.navigation.fragment.NavHostFragment
import com.example.task.Task
import com.example.tasks.R
import com.example.tasks.databinding.FragmentAddTaskBinding
import com.example.views.navigation.HomeFragmentRouter
import java.util.Date
import javax.inject.Inject

class AddTaskFragment : Fragment() {

    companion object {
        const val TAG = "AddTaskFragment"
    }

    private lateinit var localController: NavController
    private lateinit var navGraph: NavGraph

    @Inject
    lateinit var homeFragmentRouter: HomeFragmentRouter


    private val addTaskViewModel: AddTaskViewModel by viewModels()

    private lateinit var fragmentAddTaskBinding: FragmentAddTaskBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        fragmentAddTaskBinding = FragmentAddTaskBinding.inflate(inflater, container, false)

        return fragmentAddTaskBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val localNavHost =
            childFragmentManager.findFragmentById(androidx.navigation.fragment.R.id.nav_host_fragment_container) as NavHostFragment
        localController = localNavHost.navController
        val graphInflater = localNavHost.navController.navInflater
        navGraph = graphInflater.inflate(R.navigation.nav_add_task_graph)
        localController.setGraph(navGraph, null)

        with(fragmentAddTaskBinding) {
            viewModel = addTaskViewModel
            viewState = viewModel?.viewState?.value?.peekContent()
            executePendingBindings()
        }

        addTaskViewModel.viewEvent.observe(viewLifecycleOwner) {
            when(it.getContentIfNotHandled()) {
                is AddTaskViewEvent.Close -> {
                    back()
                }
                is AddTaskViewEvent.Save -> {
                    save()
                }
                else -> {}
            }
        }
    }

    private fun back() {
        homeFragmentRouter.showFromAddTask(localController, null)
    }

    private fun save() {
        val taskType: Pair<String, Int> = getTaskType()

        val task = Task(
            title = fragmentAddTaskBinding.titleTextBox.text.toString(),
            description = fragmentAddTaskBinding.descriptionTextBox.toString(),
            type = taskType,
            date = Date(),
            completed = false,
        )
        homeFragmentRouter.showFromAddTask(localController, task)
    }

    private fun getTaskType(): Pair<String, Int> {
        val checkedButtonId = fragmentAddTaskBinding.taskTypeRadioGroup.checkedRadioButtonId

        for(i in 0 until fragmentAddTaskBinding.taskTypeRadioGroup.size) {
            if(fragmentAddTaskBinding.taskTypeRadioGroup[i].id == checkedButtonId) {
                val radioButton: RadioButton =
                    fragmentAddTaskBinding.taskTypeRadioGroup[i] as RadioButton
                val taskType = radioButton.text.toString()
                val taskColor =
                    addTaskViewModel.viewState.value?.peekContent()?.taskTypeMap?.get(taskType) ?: R.color.inky
                return Pair(taskType, taskColor)
            }
        }
        return Pair("", 0)
    }
}