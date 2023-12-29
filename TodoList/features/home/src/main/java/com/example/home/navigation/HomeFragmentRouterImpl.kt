package com.example.home.navigation

import androidx.navigation.NavController
import com.example.home.NavHomeGraphDirections
import com.example.task.Task
import com.example.views.navigation.HomeFragmentRouter
import com.example.views.NavMainGraphDirections
import javax.inject.Inject

class HomeFragmentRouterImpl @Inject constructor() : HomeFragmentRouter {
    //    override fun showFromSettings(navController: NavController) {
//        navController.navigate(NavHomeGraphDirections.actionHomeToSettingsFragment())
//    }
//
//    override fun showFromExpandedTask(navController: NavController, task: Task?) {
//        navController.navigate(NavHomeGraphDirections.actionHomeToExpandedTaskFragment(task))
//    }
//
//    override fun showFromAddTask(navController: NavController) {
//        navController.navigate(NavHomeGraphDirections.actionHomeToAddTaskFragment())
//    }
    override fun show(navController: NavController) {
        navController.navigate(NavMainGraphDirections.actionToHomeFragment())
    }

    override fun showWithTask(navController: NavController, task: Task?) {
        navController.navigate(NavHomeGraphDirections.actionToHomeWithNewTask(task))
    }
}