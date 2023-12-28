package com.example.tasks.expandedtask

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.core.LiveEvent
import com.example.core.MutableLiveEvent
import com.example.core.emit
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ExpandedTaskViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    companion object {
        const val TAG = "ExpandedTaskViewModel"
    }
    private val _viewState = MutableLiveEvent<ExpandedTaskViewState>()

    val viewState: LiveEvent<ExpandedTaskViewState> get() = _viewState

    private val _viewEvent = MutableLiveEvent<ExpandedTaskViewEvent>()

    val viewEvent: LiveEvent<ExpandedTaskViewEvent> get() = _viewEvent

//    init {
//        _viewState.emit(
//            ExpandedTaskViewState(
//                //Get task from navargs
//            )
//        )
//    }

    fun backButtonPressed() {
        _viewEvent.emit(ExpandedTaskViewEvent.Close)
    }

    fun saveButtonPressed() {
        _viewEvent.emit(ExpandedTaskViewEvent.Save)
    }
}