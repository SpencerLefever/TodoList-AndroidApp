package com.example.home

import com.example.tasks.Task

data class HomeViewState(
    private val tasks: MutableList<Task> = mutableListOf()
)