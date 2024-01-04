package com.example.views.navigation

import androidx.navigation.NavController
import com.example.task.Task

interface HomeFragmentRouter {
    fun show(navController: NavController)

    fun showWithTask(navController: NavController, task: Task?)
}