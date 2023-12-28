package com.example.home.navigation

import androidx.navigation.NavController
import com.example.task.Task
import com.example.views.navigation.HomeFragmentRouter
import com.example.views.NavMainGraphDirections
import javax.inject.Inject

class HomeFragmentRouterImpl @Inject constructor() : HomeFragmentRouter {
    override fun showFromSettings(navController: NavController) {
        navController.navigate(NavMainGraphDirections.actionSettingsFragmentToHomeFragment())
    }

    override fun showFromExpandedTask(navController: NavController, task: Task?) {
        navController.navigate(NavMainGraphDirections.actionExpandedTaskFragmentToHomeFragment(task))
    }

    override fun showFromAddTask(navController: NavController, task: Task?) {
        navController.navigate(NavMainGraphDirections.actionAddTaskFragmentToHomeFragment(task))
    }

}