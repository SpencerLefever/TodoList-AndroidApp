package com.example.settings

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.user.User
import com.example.user.UserLocalRepository
import com.example.views.baselivedata.LiveEvent
import com.example.views.baselivedata.MutableLiveEvent
import com.example.views.baselivedata.emit
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

@HiltViewModel
class SettingsViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val userLocalRepository: UserLocalRepository
) : ViewModel() {
    companion object {
        const val TAG = "SettingsViewModel"
    }

    private val _viewState = MutableLiveEvent<SettingsViewState>()

    val viewState: LiveEvent<SettingsViewState> get() = _viewState

    private val _viewEvent = MutableLiveEvent<SettingsViewEvent>()

    val viewEvent: LiveEvent<SettingsViewEvent> get() = _viewEvent

    private lateinit var user: User

    init {
        runBlocking {
            user = userLocalRepository.getUser()
        }
        _viewState.emit(
            SettingsViewState(
                false,
                user.taskTypes
            )
        )
    }

    fun closeButtonPressed() {
        _viewEvent.emit(SettingsViewEvent.Close)
    }

    fun saveButtonPressed() {
        _viewEvent.emit(SettingsViewEvent.Save)
    }
}