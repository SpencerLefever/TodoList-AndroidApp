package com.example.home.navigation

import androidx.navigation.NavController
import com.example.task.Task
import com.example.views.navigation.HomeFragmentRouter
import com.example.views.NavMainGraphDirections
import javax.inject.Inject

class HomeFragmentRouterImpl @Inject constructor() : HomeFragmentRouter {
    override fun show(navController: NavController) {
        navController.navigate(NavMainGraphDirections.actionToHomeFragment())
    }

    override fun showWithTask(navController: NavController, task: Task?) {
        navController.navigate(NavMainGraphDirections.actionToHomeWithNewTask(task))
    }
}