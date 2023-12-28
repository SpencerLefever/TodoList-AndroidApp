package com.example.core.task

import java.util.Date

data class Task (
    val title: String,
    val description: String,
    val type: Pair<String, Int>?,
    val date: Date,
    var completed: Boolean
)