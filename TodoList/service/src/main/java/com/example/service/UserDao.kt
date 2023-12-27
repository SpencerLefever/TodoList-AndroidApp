package com.example.service

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Update

@Dao
interface UserDao {
    @Query("SELECT * FROM user")
    fun getUser(): User

    @Update
    fun updateUser(user: User)
}