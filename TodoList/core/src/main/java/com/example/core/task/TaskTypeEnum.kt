package com.example.core.task

import android.graphics.Color

enum class TaskTypeEnum(
        val taskType: String,
        val color: Int
) {
    WORK("Work", Color.RED),
    PERSONAL("Personal", Color.BLUE),
    SCHOOL("School", Color.GREEN);
}