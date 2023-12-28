package com.example.home

import com.example.task.Task
import com.example.task.TaskTypeEnum

data class HomeViewState(
    val tasks: MutableList<com.example.task.Task> = mutableListOf(),
    val taskTypeList: Map<String, Int> =
        mapOf(
            Pair(com.example.task.TaskTypeEnum.WORK.taskType, com.example.task.TaskTypeEnum.WORK.color),
            Pair(com.example.task.TaskTypeEnum.SCHOOL.taskType, com.example.task.TaskTypeEnum.SCHOOL.color),
            Pair(com.example.task.TaskTypeEnum.PERSONAL.taskType, com.example.task.TaskTypeEnum.PERSONAL.color)
        ))