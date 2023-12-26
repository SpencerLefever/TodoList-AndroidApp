package com.example.tasks

import java.util.Date

data class Task (
        val title: String,
        val description: String,
        val type: com.example.tasks.TaskTypeEnum?,
        val date: Date
)