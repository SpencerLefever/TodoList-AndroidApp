package com.example.tasks.addtask.di

import com.example.tasks.addtask.navigation.AddTaskFragmentRouter
import com.example.tasks.addtask.navigation.AddTaskFragmentRouterImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
object AddTaskModule {
    @Provides
    fun providesAddTaskFragmentRouter(): AddTaskFragmentRouter {
        return AddTaskFragmentRouterImpl()
    }
}