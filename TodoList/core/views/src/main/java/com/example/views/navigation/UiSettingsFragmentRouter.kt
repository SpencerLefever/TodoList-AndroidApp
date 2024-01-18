package com.example.views.navigation

import androidx.navigation.NavController

interface UiSettingsFragmentRouter {

    fun show(navController: NavController)

    fun showSettings(navController: NavController)
}