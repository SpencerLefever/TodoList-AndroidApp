package com.example.user

import com.example.task.Task
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserLocalRepository @Inject constructor(
    private val userDao: UserDao
) : IUserLocalRepository {
    override suspend fun getUser(): User {
        return userDao.getUser()
    }

    override suspend fun getUserTasks(): MutableList<Task> {
        return userDao.getUser().tasks
    }

    override suspend fun getUserTaskTypes(): Map<String, Int> {
        return userDao.getUser().taskTypes
    }

    override suspend fun updateUser(user: User) {
        userDao.updateUser(user)
    }

    override suspend fun insertUser(user: User) {
        userDao.insertUser(user)
    }
    override suspend fun deleteTask(task: Task) {
        val user = getUser()
        user.tasks.remove(task)
        updateUser(user)
    }
}