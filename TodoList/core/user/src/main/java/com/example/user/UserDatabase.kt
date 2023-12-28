package com.example.user

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(entities = [User::class], version = 1)
@TypeConverters(TaskConverter::class)
abstract class UserDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}