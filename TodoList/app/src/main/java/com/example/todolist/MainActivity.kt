package com.example.todolist

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.databinding.DataBindingUtil
import com.example.common_libs.Constants
import com.example.views.databinding.HomeFragmentContainerBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    companion object {
        private const val TAG = "MainActivity"
    }

    private lateinit var homeFragmentContainerBinding: HomeFragmentContainerBinding
    private lateinit var sharedPreferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setDarkModeSettings()

        homeFragmentContainerBinding = DataBindingUtil.setContentView(this, com.example.views.R.layout.home_fragment_container)
    }

    private fun setDarkModeSettings() {
        sharedPreferences = getSharedPreferences(Constants.PREFERENCES, Context.MODE_PRIVATE)
        when(sharedPreferences.getInt(Constants.NIGHT_MODE, 0)) {
            AppCompatDelegate.MODE_NIGHT_YES -> {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            }
            AppCompatDelegate.MODE_NIGHT_NO -> {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            }
            else -> {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM)
            }
        }
    }

}