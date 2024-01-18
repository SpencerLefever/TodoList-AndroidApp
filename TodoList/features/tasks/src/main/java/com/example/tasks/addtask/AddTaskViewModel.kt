package com.example.tasks.addtask

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.common_libs.IoDispatcher
import com.example.user.IUserLocalRepository
import com.example.views.baselivedata.LiveEvent
import com.example.views.baselivedata.MutableLiveEvent
import com.example.views.baselivedata.emit
import javax.inject.Inject
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

@HiltViewModel
class AddTaskViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val userLocalRepository: IUserLocalRepository,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher
) : ViewModel() {
    companion object {
        const val TAG = "AddTaskViewModel"
    }

    private val _viewState = MutableLiveEvent<AddTaskViewState>()

    val viewState: LiveEvent<AddTaskViewState> get() = _viewState

    private val _viewEvent = MutableLiveEvent<AddTaskViewEvent>()

    val viewEvent: LiveEvent<AddTaskViewEvent> get() = _viewEvent

    private lateinit var userTaskMap: Map<String, Int>

    init {
        runBlocking {
            getUserTaskTypes()
        }
        _viewState.emit(
            AddTaskViewState(
                userTaskMap
            )
        )
    }

    fun backButtonPressed() {
        _viewEvent.emit(AddTaskViewEvent.Close)
    }

    fun saveButtonPressed() {
        _viewEvent.emit(AddTaskViewEvent.Save)
    }

    private suspend fun getUserTaskTypes(){
        withContext(ioDispatcher) {
            userTaskMap = userLocalRepository.getUserTaskTypes()
        }
    }
}