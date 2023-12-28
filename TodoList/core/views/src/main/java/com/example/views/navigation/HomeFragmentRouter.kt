package com.example.views.navigation

import androidx.navigation.NavController
import com.example.task.Task

interface HomeFragmentRouter {
    fun showFromSettings(navController: NavController)

    fun showFromExpandedTask(navController: NavController, task: Task?)

    fun showFromAddTask(navController: NavController, task: Task?)
}