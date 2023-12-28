package com.example.tasks.addtask

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.views.baselivedata.LiveEvent
import com.example.views.baselivedata.MutableLiveEvent
import com.example.views.baselivedata.emit
import javax.inject.Inject
import dagger.hilt.android.lifecycle.HiltViewModel

@HiltViewModel
class AddTaskViewModel @Inject constructor(
        private val savedStateHandle: SavedStateHandle
) : ViewModel() {
    companion object {
        const val TAG = "AddTaskViewModel"
    }

    private val _viewState = MutableLiveEvent<AddTaskViewState>()

    val viewState: LiveEvent<AddTaskViewState> get() = _viewState

    private val _viewEvent = MutableLiveEvent<AddTaskViewEvent>()

    val viewEvent: LiveEvent<AddTaskViewEvent> get() = _viewEvent

    init {
        _viewState.emit(
            AddTaskViewState(

            )
        )
    }

    fun backButtonPressed() {
        _viewEvent.emit(AddTaskViewEvent.Close)
    }

    fun saveButtonPressed() {
        _viewEvent.emit(AddTaskViewEvent.Save)
    }
}