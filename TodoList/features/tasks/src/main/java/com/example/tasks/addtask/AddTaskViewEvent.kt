package com.example.tasks.addtask

sealed class AddTaskViewEvent {
    object Close: AddTaskViewEvent()

    object Save: AddTaskViewEvent()
}