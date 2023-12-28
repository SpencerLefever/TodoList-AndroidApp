package com.example.settings.navigation

import androidx.navigation.NavController
import com.example.views.NavMainGraphDirections
import com.example.views.navigation.SettingsFragmentRouter
import javax.inject.Inject

class SettingsFragmentaRouterImpl @Inject constructor() : SettingsFragmentRouter {

    override fun show(navController: NavController) {
        navController.navigate(NavMainGraphDirections.actionHomeToSettingsFragment())
    }
}