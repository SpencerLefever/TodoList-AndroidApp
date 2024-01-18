package com.example.settings.general

import com.example.task.TaskTypeEnum

data class SettingsViewState(
    val darkMode: Boolean = false,
    val taskTypeList: Map<String, Int> =
        mapOf(
            Pair(TaskTypeEnum.WORK.taskType, TaskTypeEnum.WORK.color),
            Pair(TaskTypeEnum.SCHOOL.taskType, TaskTypeEnum.SCHOOL.color),
            Pair(TaskTypeEnum.PERSONAL.taskType, TaskTypeEnum.PERSONAL.color)
        )
)