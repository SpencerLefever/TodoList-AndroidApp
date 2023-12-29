package com.example.tasks.addtask.navigation

import androidx.navigation.NavController
import com.example.views.NavMainGraphDirections
import com.example.views.navigation.AddTaskFragmentRouter
import javax.inject.Inject

class AddTaskFragmentRouterImpl @Inject constructor() : AddTaskFragmentRouter {

    override fun show(navController: NavController) {
        navController.navigate(NavMainGraphDirections.actionToAddTaskFragment())
    }
}