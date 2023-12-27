package com.example.settings

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import com.example.settings.databinding.FragmentSettingsBinding

class SettingsFragment : Fragment() {

    companion object {
        const val TAG = "SettingsFragment"
    }

    private lateinit var localController: NavController

    private val settingsViewModel: SettingsViewModel by viewModels()

    private lateinit var fragmentSettingsBinding: FragmentSettingsBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(fragmentSettingsBinding) {
            viewModel = settingsViewModel
            viewState = viewModel?.viewState?.value?.peekContent()
            executePendingBindings()
        }

        settingsViewModel.viewEvent.observe(viewLifecycleOwner) {
            when(it.getContentIfNotHandled()) {
                is SettingsViewEvent.Save -> {
                    saveSettings()
                    navigateToHome()
                }
                is SettingsViewEvent.Close -> {
                    navigateToHome()
                }
                else -> {}
            }
        }

        settingsViewModel.viewState.observe(viewLifecycleOwner) {
            //Populate task list and colors in rv
        }
    }

    private fun navigateToHome() {

    }

    private fun saveSettings() {

    }
}