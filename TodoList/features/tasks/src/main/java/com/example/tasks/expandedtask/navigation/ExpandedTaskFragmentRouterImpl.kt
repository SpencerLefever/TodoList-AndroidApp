package com.example.tasks.expandedtask.navigation

import androidx.navigation.NavController
import com.example.task.Task
import com.example.views.NavMainGraphDirections
import com.example.views.navigation.ExpandedTaskFragmentRouter
import javax.inject.Inject

class ExpandedTaskFragmentRouterImpl @Inject constructor() : ExpandedTaskFragmentRouter {

    override fun show(navController: NavController, task: Task) {
        navController.navigate(NavMainGraphDirections.actionHomeToExpandedTaskFragment(task))
    }
}