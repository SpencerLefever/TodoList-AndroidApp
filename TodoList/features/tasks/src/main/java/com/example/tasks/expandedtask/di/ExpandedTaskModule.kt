package com.example.tasks.expandedtask.di

import com.example.views.navigation.ExpandedTaskFragmentRouter
import com.example.tasks.expandedtask.navigation.ExpandedTaskFragmentRouterImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
object ExpandedTaskModule {

    @Provides
    fun providesExpandedTaskRouter(): ExpandedTaskFragmentRouter {
        return ExpandedTaskFragmentRouterImpl()
    }
}