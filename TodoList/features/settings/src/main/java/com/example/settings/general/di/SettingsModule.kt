package com.example.settings.general.di

import com.example.views.navigation.SettingsFragmentRouter
import com.example.settings.general.navigation.SettingsFragmentRouterImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
object SettingsModule {

    @Provides
    fun providesSettingsFragmentRouter(): SettingsFragmentRouter {
        return SettingsFragmentRouterImpl()
    }
}