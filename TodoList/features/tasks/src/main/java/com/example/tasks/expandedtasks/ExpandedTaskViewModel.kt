package com.example.tasks.expandedtasks

import androidx.lifecycle.SavedStateHandle
import com.example.service.LiveEvent
import com.example.service.MutableLiveEvent
import com.example.service.emit
import com.example.tasks.Task
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ExpandedTaskViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle
) {

    companion object {
        const val TAG = "ExpandedTaskViewModel"
    }
    private val _viewState = MutableLiveEvent<ExpandedTaskViewState>()

    val viewState: LiveEvent<ExpandedTaskViewState> get() = _viewState

    private val _viewEvent = MutableLiveEvent<ExpandedTaskViewEvent>()

    val viewEvent: LiveEvent<ExpandedTaskViewEvent> get() = _viewEvent

    init {
        _viewState.emit(
            ExpandedTaskViewState(
                //Get task from navargs
            )
        )
    }

    fun backButtonPressed() {
        _viewEvent.emit(ExpandedTaskViewEvent.Close)
    }

    fun saveButtonPressed() {
        _viewEvent.emit(ExpandedTaskViewEvent.Save)
    }
}