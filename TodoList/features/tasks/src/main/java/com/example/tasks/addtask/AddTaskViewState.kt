package com.example.tasks.addtask

import com.example.task.TaskTypeEnum

class AddTaskViewState {
    val taskTypeMap: Map<String, Int> =
        mapOf(
            Pair(com.example.task.TaskTypeEnum.WORK.taskType, com.example.task.TaskTypeEnum.WORK.color),
            Pair(com.example.task.TaskTypeEnum.SCHOOL.taskType, com.example.task.TaskTypeEnum.SCHOOL.color),
            Pair(com.example.task.TaskTypeEnum.PERSONAL.taskType, com.example.task.TaskTypeEnum.PERSONAL.color)
        )
}