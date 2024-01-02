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

    override suspend fun getUserTasks(): List<Task> {
        return userDao.getUser().tasks ?: emptyList()
    }

    override suspend fun getUserTaskTypes(): Map<String, Int> {
        return userDao.getUser().taskTypes ?: emptyMap()
    }

    override suspend fun updateUser(user: User) {
        userDao.updateUser(user)
    }
}