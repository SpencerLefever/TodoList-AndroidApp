package com.example.tasks

sealed class AddTaskViewEvent {
    object Close: AddTaskViewEvent()

    object Save: AddTaskViewEvent()
}