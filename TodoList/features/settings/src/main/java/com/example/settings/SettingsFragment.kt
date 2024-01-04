package com.example.settings

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import androidx.navigation.NavGraph
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.example.settings.databinding.FragmentSettingsBinding
import com.example.views.navigation.HomeFragmentRouter
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class SettingsFragment : Fragment() {

    companion object {
        const val TAG = "SettingsFragment"
    }

    private lateinit var localController: NavController
    private lateinit var navGraph: NavGraph

    @Inject
    lateinit var homeFragmentRouter: HomeFragmentRouter

    private val settingsViewModel: SettingsViewModel by viewModels()

    private lateinit var fragmentSettingsBinding: FragmentSettingsBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        localController = this.findNavController()

        with(fragmentSettingsBinding) {
            viewModel = settingsViewModel
            viewState = viewModel?.viewState?.value?.peekContent()
            executePendingBindings()
        }

        settingsViewModel.viewEvent.observe(viewLifecycleOwner) {
            when(it.getContentIfNotHandled()) {
                is SettingsViewEvent.Save -> {
                    saveSettings()
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
        homeFragmentRouter.show(localController)
    }

    //TODO provide functionality to save settings when task type settings are created
    private fun saveSettings() {
        homeFragmentRouter.show(localController)
    }
}