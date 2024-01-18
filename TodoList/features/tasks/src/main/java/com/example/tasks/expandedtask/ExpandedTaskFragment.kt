package com.example.tasks.expandedtask

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import androidx.navigation.NavGraph
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.task.Task
import com.example.tasks.R
import com.example.tasks.databinding.FragmentExpandedTaskBinding
import com.example.views.navigation.HomeFragmentRouter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.runBlocking
import java.text.SimpleDateFormat
import java.util.Locale
import javax.inject.Inject

@AndroidEntryPoint
class ExpandedTaskFragment: Fragment() {

    companion object {
        const val TAG = "ExpandedTaskFragment"
    }

    private val args: ExpandedTaskFragmentArgs by navArgs()
    private lateinit var localController: NavController

    @Inject
    lateinit var homeFragmentRouter: HomeFragmentRouter

    private val expandedTaskViewModel: ExpandedTaskViewModel by viewModels()

    private lateinit var fragmentExpandedTaskBinding: FragmentExpandedTaskBinding

    private lateinit var originalTask: Task

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentExpandedTaskBinding = FragmentExpandedTaskBinding.inflate(inflater, container, false)

        return fragmentExpandedTaskBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        localController = this.findNavController()

        val expandedTask: Task = args.taskKey
        originalTask = expandedTask
        expandedTaskViewModel.emitInitialViewState(
            ExpandedTaskViewState(expandedTask)
        )
        val simpleDateFormat = SimpleDateFormat("MM-dd HH:mm", Locale.US)
        fragmentExpandedTaskBinding.dateHeader.text = simpleDateFormat.format(expandedTask.date).toString()

        with(fragmentExpandedTaskBinding) {
            viewModel = expandedTaskViewModel
            viewState = viewModel?.viewState?.value?.peekContent()
            executePendingBindings()
        }

        expandedTaskViewModel.viewEvent.observe(viewLifecycleOwner) {
            when(it.getContentIfNotHandled()) {
                is ExpandedTaskViewEvent.Close -> {
                    close()
                }
                is ExpandedTaskViewEvent.Save -> {
                    runBlocking {
                        expandedTaskViewModel.deleteOutdatedTask(originalTask)
                    }
                    save()
                }
                else -> {}
            }
        }
    }

    private fun save() {
        expandedTaskViewModel
        homeFragmentRouter.showWithTask(localController, getTask())
    }

    private fun close() {
        homeFragmentRouter.show(localController)
    }

    //TODO get task type from radio group when functionality to change task is added
    private fun getTask() =
        expandedTaskViewModel.viewState.value?.peekContent()?.task?.date?.let {
            expandedTaskViewModel.viewState.value?.peekContent()?.task?.completed?.let { it1 ->
                Task(
                    title = fragmentExpandedTaskBinding.titleTextBox.text.toString(),
                    description = fragmentExpandedTaskBinding.descriptionTextBox.text.toString(),
                    type = expandedTaskViewModel.viewState.value?.peekContent()?.task?.type,
                    date = it,
                    completed = it1
                )
            }
        }
}