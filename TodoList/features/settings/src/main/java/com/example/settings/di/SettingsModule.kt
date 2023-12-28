package com.example.settings.di

import com.example.views.navigation.SettingsFragmentRouter
import com.example.settings.navigation.SettingsFragmentaRouterImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
object SettingsModule {

    @Provides
    fun providesSettingsFragmentRouter(): SettingsFragmentRouter {
        return SettingsFragmentaRouterImpl()
    }
}