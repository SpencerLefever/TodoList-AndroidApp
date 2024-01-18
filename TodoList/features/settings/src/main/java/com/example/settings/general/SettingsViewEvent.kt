package com.example.settings.general

sealed class SettingsViewEvent {
    object Close: SettingsViewEvent()

    object UiSettings: SettingsViewEvent()

    object TaskSettings: SettingsViewEvent()
}