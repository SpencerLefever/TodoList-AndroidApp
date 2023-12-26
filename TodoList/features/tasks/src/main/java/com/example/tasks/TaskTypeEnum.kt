package com.example.tasks

import android.graphics.Color

enum class TaskTypeEnum(
        val taskType: String,
        val color: Int
) {
    WORK("Work", Color.RED),
    PERSONAL("Personal", Color.BLUE),
    SCHOOL("School", Color.GREEN);

    companion object {
        fun getByType(type: String): TaskTypeEnum = entries.find { it.name == type } ?: WORK
    }
}