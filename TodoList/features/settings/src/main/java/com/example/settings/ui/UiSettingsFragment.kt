package com.example.settings.ui

import android.app.UiModeManager
import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatDelegate
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.common_libs.Constants
import com.example.settings.databinding.FragmentUiSettingsBinding
import com.example.views.navigation.UiSettingsFragmentRouter
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class UiSettingsFragment : Fragment() {

    companion object {
        const val TAG = "UiSettingsFragment"
    }

    private lateinit var localController: NavController

    @Inject
    lateinit var uiSettingsFragmentRouter: UiSettingsFragmentRouter

    private val uiSettingsViewModel: UiSettingsViewModel by viewModels()

    private lateinit var fragmentUiSettingsBinding: FragmentUiSettingsBinding

    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentUiSettingsBinding = FragmentUiSettingsBinding.inflate(inflater, container, false)
        return fragmentUiSettingsBinding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        localController = this.findNavController()
        sharedPreferences = requireContext().getSharedPreferences(Constants.PREFERENCES, Context.MODE_PRIVATE)

        with(fragmentUiSettingsBinding) {
            viewModel = uiSettingsViewModel
            viewState = viewModel?.viewState?.value?.peekContent()
            executePendingBindings()
        }

        setCardBindings()

        uiSettingsViewModel.viewEvent.observe(viewLifecycleOwner) {
            when(it.getContentIfNotHandled()) {
                is UiSettingsViewEvent.Close -> {
                    navigateToSettings()
                }
                is UiSettingsViewEvent.LightMode -> {
                    lightModeEnabled()
                }
                is UiSettingsViewEvent.DarkMode -> {
                    darkModeEnabled()
                }
                is UiSettingsViewEvent.SystemSettings -> {
                    systemSettingsEnabled()
                }
                else -> {}
            }
        }
    }

    private fun navigateToSettings() {
        uiSettingsFragmentRouter.showSettings(localController)
    }

    private fun lightModeEnabled() {
        fragmentUiSettingsBinding.lightModeCard.checkMark.visibility = View.VISIBLE
        fragmentUiSettingsBinding.darkModeCard.checkMark.visibility = View.INVISIBLE
        fragmentUiSettingsBinding.systemSettingsCard.checkMark.visibility = View.INVISIBLE
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        sharedPreferences?.edit()?.putInt(Constants.NIGHT_MODE, AppCompatDelegate.MODE_NIGHT_NO)?.apply()

    }

    private fun darkModeEnabled() {
        fragmentUiSettingsBinding.lightModeCard.checkMark.visibility = View.INVISIBLE
        fragmentUiSettingsBinding.darkModeCard.checkMark.visibility = View.VISIBLE
        fragmentUiSettingsBinding.systemSettingsCard.checkMark.visibility = View.INVISIBLE
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        sharedPreferences?.edit()?.putInt(Constants.NIGHT_MODE, AppCompatDelegate.MODE_NIGHT_YES)?.apply()

    }

    private fun systemSettingsEnabled() {
        fragmentUiSettingsBinding.lightModeCard.checkMark.visibility = View.INVISIBLE
        fragmentUiSettingsBinding.darkModeCard.checkMark.visibility = View.INVISIBLE
        fragmentUiSettingsBinding.systemSettingsCard.checkMark.visibility = View.VISIBLE
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM)
        sharedPreferences?.edit()?.putInt(Constants.NIGHT_MODE, AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM)?.apply()
    }

    private fun setCardBindings() {
        fragmentUiSettingsBinding.lightModeCard.textHeader.text = requireContext().getText(com.example.common_libs.R.string.light_mode)
        fragmentUiSettingsBinding.lightModeCard.textDescription.text = requireContext().getText(com.example.common_libs.R.string.light_mode_desc)
        fragmentUiSettingsBinding.darkModeCard.textHeader.text = requireContext().getText(com.example.common_libs.R.string.dark_mode)
        fragmentUiSettingsBinding.lightModeCard.textDescription.text = requireContext().getText(com.example.common_libs.R.string.dark_mode_desc)
        fragmentUiSettingsBinding.systemSettingsCard.textHeader.text = requireContext().getText(com.example.common_libs.R.string.system_settings)
        fragmentUiSettingsBinding.systemSettingsCard.textDescription.text = requireContext().getText(com.example.common_libs.R.string.system_settings_desc)
        when(AppCompatDelegate.getDefaultNightMode()) {
            AppCompatDelegate.MODE_NIGHT_YES ->
                darkModeEnabled()
            AppCompatDelegate.MODE_NIGHT_NO ->
                lightModeEnabled()
            else ->
                systemSettingsEnabled()
        }
    }
}