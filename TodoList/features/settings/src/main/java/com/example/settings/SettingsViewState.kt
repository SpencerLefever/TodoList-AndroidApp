package com.example.settings

import com.example.core.task.TaskTypeEnum

data class SettingsViewState(
    val darkMode: Boolean = false,
    val taskTypeList: Map<String, Int> =
        mapOf(
            Pair(TaskTypeEnum.WORK.taskType, TaskTypeEnum.WORK.color),
            Pair(TaskTypeEnum.SCHOOL.taskType, TaskTypeEnum.SCHOOL.color),
            Pair(TaskTypeEnum.PERSONAL.taskType, TaskTypeEnum.PERSONAL.color)
        )
)