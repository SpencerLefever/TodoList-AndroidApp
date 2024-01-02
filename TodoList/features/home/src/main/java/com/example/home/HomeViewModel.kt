package com.example.home

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.common_libs.IoDispatcher
import com.example.task.Task
import com.example.user.IUserLocalRepository
import com.example.user.User
import com.example.user.UserDao
import com.example.views.baselivedata.LiveEvent
import com.example.views.baselivedata.MutableLiveEvent
import com.example.views.baselivedata.emit
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val userLocalRepository: IUserLocalRepository,
    @IoDispatcher val ioDispatcher: CoroutineDispatcher

) : ViewModel() {

    companion object {
        const val TAG = "HomeViewModel"
    }

    private val _viewState = MutableLiveEvent<HomeViewState>()

    val viewState: LiveEvent<HomeViewState> get() = _viewState

    private val _viewEvent = MutableLiveEvent<HomeViewEvent>()

    val viewEvent: LiveEvent<HomeViewEvent> get() = _viewEvent

    private var user: User

    init {
        runBlocking {
            withContext(ioDispatcher) {
                user = userLocalRepository.getUser()
            }
        }
        Log.d(TAG, "User: $user")
        _viewState.emit(
            HomeViewState(
                user.tasks ?: mutableListOf()
            )
        )
    }

    fun filterButtonPressed() {
        _viewEvent.emit(HomeViewEvent.Filter)
    }

    fun settingButtonPressed() {
        _viewEvent.emit(HomeViewEvent.Settings)
    }

    fun addTaskButtonPressed() {
        _viewEvent.emit(HomeViewEvent.AddTask)
    }

    fun completeTaskPressed() {
        _viewEvent.emit(HomeViewEvent.CompleteTask)
    }

    fun deleteTaskPressed() {
        _viewEvent.emit(HomeViewEvent.DeleteTask)
    }

    fun expandTaskPressed() {
        _viewEvent.emit(HomeViewEvent.ExpandTask)
    }

    fun deleteTask(task: Task?) {
        viewModelScope.launch {
            user.tasks?.remove(task)
            userLocalRepository.updateUser(user)
        }
    }

    fun updateCompleteTaskValue(task: Task?, completed: Boolean) {
        viewModelScope.launch {
            user.tasks?.find { it.title == task?.title }?.completed = completed
            userLocalRepository.updateUser(user)
        }
    }
}