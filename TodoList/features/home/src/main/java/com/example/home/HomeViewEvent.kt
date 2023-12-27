package com.example.home

sealed class HomeViewEvent {
    object AddTask: HomeViewEvent()

    object Filter: HomeViewEvent()

    object Settings: HomeViewEvent()

    object CompleteTask: HomeViewEvent()

    object RemoveCompleteTask: HomeViewEvent()

    object DeleteTask: HomeViewEvent()

    object ExpandTask: HomeViewEvent()
}