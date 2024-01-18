package com.example.settings.ui.navigation

import androidx.navigation.NavController
import com.example.settings.NavSettingsGraphDirections
import com.example.views.NavMainGraphDirections
import com.example.views.navigation.UiSettingsFragmentRouter
import javax.inject.Inject

class UiSettingsFragmentRouterImpl @Inject constructor() : UiSettingsFragmentRouter {
    override fun show(navController: NavController) {
        navController.navigate(NavSettingsGraphDirections.actionToUiSettingsFragment())
    }

    override fun showSettings(navController: NavController) {
        navController.navigate(NavMainGraphDirections.actionToSettingsFragment())
    }
}