package com.example.home

import com.example.tasks.Task

data class HomeViewState(
    val tasks: MutableList<Task> = mutableListOf()
)