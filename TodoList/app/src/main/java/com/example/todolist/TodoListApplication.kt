package com.example.todolist

import android.app.Application
import android.content.Intent
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class TodoListApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        navigateToMainActivity()
    }

    private fun navigateToMainActivity() {
        val intent = Intent(this, MainActivity::class.java)
        intent.flags =
            Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        this.startActivity(intent)
    }
}