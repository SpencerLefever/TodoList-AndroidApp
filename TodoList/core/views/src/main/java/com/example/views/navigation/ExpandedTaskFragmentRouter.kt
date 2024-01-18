package com.example.views.navigation

import androidx.navigation.NavController
import com.example.task.Task

interface ExpandedTaskFragmentRouter {

    fun show(navController: NavController, task: Task)
}