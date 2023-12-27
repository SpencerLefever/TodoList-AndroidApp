package com.example.settings

sealed class SettingsViewEvent {
    object Close: SettingsViewEvent()

    object Save: SettingsViewEvent()
}