package com.example.home.di

import com.example.views.navigation.HomeFragmentRouter
import com.example.home.navigation.HomeFragmentRouterImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
object HomeModule {

    @Provides
    fun providesHomeFragmentRouter(): HomeFragmentRouter {
        return HomeFragmentRouterImpl()
    }
}