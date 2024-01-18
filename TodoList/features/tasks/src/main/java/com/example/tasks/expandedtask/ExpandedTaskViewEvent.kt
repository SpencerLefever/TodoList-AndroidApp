package com.example.tasks.expandedtask

sealed class ExpandedTaskViewEvent {
    object Save: ExpandedTaskViewEvent()

    object Close: ExpandedTaskViewEvent()
}