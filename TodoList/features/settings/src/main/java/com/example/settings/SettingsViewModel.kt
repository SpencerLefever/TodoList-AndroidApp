package com.example.settings

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.core.LiveEvent
import com.example.core.MutableLiveEvent
import com.example.core.emit
import com.example.core.user.User
import com.example.core.user.UserDao
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

@HiltViewModel
class SettingsViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    val userDao: UserDao
) : ViewModel() {
    companion object {
        const val TAG = "SettingsViewModel"
    }

    private val _viewState = MutableLiveEvent<SettingsViewState>()

    val viewState: LiveEvent<SettingsViewState> get() = _viewState

    private val _viewEvent = MutableLiveEvent<SettingsViewEvent>()

    val viewEvent: LiveEvent<SettingsViewEvent> get() = _viewEvent

    private var user: User

    init {
        runBlocking {
            user = userDao.getUser()
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