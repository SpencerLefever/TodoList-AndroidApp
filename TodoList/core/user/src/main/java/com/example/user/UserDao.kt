package com.example.user

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface UserDao {
    @Query("SELECT * FROM User")
    fun getUser(): User

    @Update
    fun updateUser(user: User)

    @Insert
    fun insertUser(user: User)
}