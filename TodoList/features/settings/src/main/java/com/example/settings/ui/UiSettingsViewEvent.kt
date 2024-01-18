package com.example.settings.ui


sealed class UiSettingsViewEvent {

    object Close: UiSettingsViewEvent()

    object LightMode: UiSettingsViewEvent()

    object DarkMode: UiSettingsViewEvent()

    object SystemSettings: UiSettingsViewEvent()
}