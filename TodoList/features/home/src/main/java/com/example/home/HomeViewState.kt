package com.example.home

import com.example.task.Task
import com.example.task.TaskTypeEnum

data class HomeViewState(
    val tasks: MutableList<Task> = mutableListOf(),
    val taskTypeList: Map<String, Int> =
        mapOf(
            Pair(TaskTypeEnum.WORK.taskType, TaskTypeEnum.WORK.color),
            Pair(TaskTypeEnum.SCHOOL.taskType, TaskTypeEnum.SCHOOL.color),
            Pair(TaskTypeEnum.PERSONAL.taskType, TaskTypeEnum.PERSONAL.color)
        ))