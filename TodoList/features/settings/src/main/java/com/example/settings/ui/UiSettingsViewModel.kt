package com.example.settings.ui

import androidx.lifecycle.ViewModel
import com.example.views.baselivedata.LiveEvent
import com.example.views.baselivedata.MutableLiveEvent
import com.example.views.baselivedata.emit
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class UiSettingsViewModel @Inject constructor() : ViewModel() {

    companion object {
        const val TAG = "UiSettingsViewModel"
    }

    private val _viewState = MutableLiveEvent<UiSettingsViewState>()

    val viewState: LiveEvent<UiSettingsViewState> get() = _viewState

    private val _viewEvent = MutableLiveEvent<UiSettingsViewEvent>()

    val viewEvent: LiveEvent<UiSettingsViewEvent> get() = _viewEvent

    fun closeButtonPressed() {
        _viewEvent.emit(UiSettingsViewEvent.Close)
    }

    fun lightModeCardPressed() {
        _viewEvent.emit(UiSettingsViewEvent.LightMode)
    }

    fun darkModeCardPressed() {
        _viewEvent.emit(UiSettingsViewEvent.DarkMode)
    }

    fun systemSettingsCardPressed() {
        _viewEvent.emit(UiSettingsViewEvent.SystemSettings)
    }

}