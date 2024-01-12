package com.example.tasks.addtask

import com.example.task.TaskTypeEnum

data class AddTaskViewState (
    val taskTypeMap: Map<String, Int> =
        mapOf(
            Pair(TaskTypeEnum.WORK.taskType, TaskTypeEnum.WORK.color),
            Pair(TaskTypeEnum.SCHOOL.taskType, TaskTypeEnum.SCHOOL.color),
            Pair(TaskTypeEnum.PERSONAL.taskType, TaskTypeEnum.PERSONAL.color)
        )
)