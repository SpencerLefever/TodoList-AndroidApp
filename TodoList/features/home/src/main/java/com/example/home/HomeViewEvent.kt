package com.example.home

sealed class HomeViewEvent {
    object AddTask: HomeViewEvent()

    object Filter: HomeViewEvent()

    object Settings: HomeViewEvent()
}