package com.example.tasks.expandedtask

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.common_libs.IoDispatcher
import com.example.task.Task
import com.example.user.IUserLocalRepository
import com.example.views.baselivedata.LiveEvent
import com.example.views.baselivedata.MutableLiveEvent
import com.example.views.baselivedata.emit
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class ExpandedTaskViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val userLocalRepository: IUserLocalRepository,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher
) : ViewModel() {

    companion object {
        const val TAG = "ExpandedTaskViewModel"
    }
    private val _viewState = MutableLiveEvent<ExpandedTaskViewState>()

    val viewState: LiveEvent<ExpandedTaskViewState> get() = _viewState

    private val _viewEvent = MutableLiveEvent<ExpandedTaskViewEvent>()

    val viewEvent: LiveEvent<ExpandedTaskViewEvent> get() = _viewEvent

    fun emitInitialViewState(viewState: ExpandedTaskViewState) {
        _viewState.emit(
            viewState
        )
    }

    fun backButtonPressed() {
        _viewEvent.emit(ExpandedTaskViewEvent.Close)
    }

    fun saveButtonPressed() {
        _viewEvent.emit(ExpandedTaskViewEvent.Save)
    }

    suspend fun deleteOutdatedTask(task: Task) {
        withContext(ioDispatcher) {
            userLocalRepository.deleteTask(task)
        }
    }
}