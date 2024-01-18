package com.example.user

import com.example.task.Task

interface IUserLocalRepository {
    suspend fun getUser(): User
    suspend fun getUserTasks(): List<Task>
    suspend fun getUserTaskTypes(): Map<String, Int>
    suspend fun updateUser(user: User)
    suspend fun insertUser(user: User)
    suspend fun deleteTask(task: Task)
}