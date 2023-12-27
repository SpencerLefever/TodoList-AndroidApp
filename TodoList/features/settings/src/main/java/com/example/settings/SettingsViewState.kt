package com.example.settings

import com.example.tasks.TaskTypeEnum

data class SettingsViewState(
    val darkMode: Boolean = false,
    val taskTypeList: List<TaskTypeEnum> = emptyList()
)