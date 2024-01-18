package com.example.settings.general.navigation

import androidx.navigation.NavController
import com.example.views.NavMainGraphDirections
import com.example.views.navigation.SettingsFragmentRouter
import javax.inject.Inject

class SettingsFragmentRouterImpl @Inject constructor() : SettingsFragmentRouter {

    override fun show(navController: NavController) {
        navController.navigate(NavMainGraphDirections.actionToSettingsFragment())
    }
}