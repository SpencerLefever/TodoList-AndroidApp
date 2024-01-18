package com.example.settings.ui.di

import com.example.settings.ui.navigation.UiSettingsFragmentRouterImpl
import com.example.views.navigation.UiSettingsFragmentRouter
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
object UiSettingsModule {

    @Provides
    fun providesUiSettingsFragmentRouter(): UiSettingsFragmentRouter {
        return UiSettingsFragmentRouterImpl()
    }
}