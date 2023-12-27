package com.example.home

import androidx.lifecycle.ViewModel
import com.example.service.LiveEvent
import com.example.service.MutableLiveEvent
import com.example.service.emit
import com.example.service.User
import com.example.service.UserDao
import com.example.tasks.Task
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    val userDao: UserDao
) : ViewModel() {

    companion object {
        const val TAG = "HomeViewModel"
    }

    private val _viewState = MutableLiveEvent<HomeViewState>()

    val viewState: LiveEvent<HomeViewState> get() = _viewState

    private val _viewEvent = MutableLiveEvent<HomeViewEvent>()

    val viewEvent: LiveEvent<HomeViewEvent> get() = _viewEvent

    private lateinit var user: User

    init {
        runBlocking {
            user = userDao.getUser()
        }

        _viewState.emit(
            HomeViewState(
                user.tasks
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

    fun deleteTask(task: Task) {
        user.tasks.remove(task)
        userDao.updateUser(user)
    }

    fun completeTask(task: Task) {
        user.tasks.find { it.title == task.title }?.completed = false
        userDao.updateUser(user)
    }
}