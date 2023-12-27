package com.example.tasks.expandedtasks

sealed class ExpandedTaskViewEvent {
    object Save: ExpandedTaskViewEvent()

    object Close: ExpandedTaskViewEvent()
}