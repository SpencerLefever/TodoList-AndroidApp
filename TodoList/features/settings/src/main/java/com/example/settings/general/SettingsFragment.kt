package com.example.settings.general

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.example.settings.databinding.FragmentSettingsBinding
import com.example.views.navigation.HomeFragmentRouter
import com.example.views.navigation.UiSettingsFragmentRouter
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class SettingsFragment : Fragment() {

    companion object {
        const val TAG = "SettingsFragment"
    }

    private lateinit var localController: NavController

    @Inject
    lateinit var homeFragmentRouter: HomeFragmentRouter

    @Inject
    lateinit var uiSettingsFragmentRouter: UiSettingsFragmentRouter

    private val settingsViewModel: SettingsViewModel by viewModels()

    private lateinit var fragmentSettingsBinding: FragmentSettingsBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentSettingsBinding = FragmentSettingsBinding.inflate(inflater, container, false)
        return fragmentSettingsBinding.root
    }
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
                is SettingsViewEvent.UiSettings -> {
                    navigateToUiSettings()
                }
                is SettingsViewEvent.TaskSettings -> {
                    navigateToTaskSettings()
                }
                is SettingsViewEvent.Close -> {
                    navigateToHome()
                }
                else -> {}
            }
        }

        settingsViewModel.viewState.observe(viewLifecycleOwner) {

        }
    }

    private fun navigateToHome() {
        homeFragmentRouter.show(localController)
    }

    private fun navigateToUiSettings() {
        uiSettingsFragmentRouter.show(localController)
    }

    private fun navigateToTaskSettings() {

    }
}