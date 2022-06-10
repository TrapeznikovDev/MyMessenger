package com.trapeznikovdm.messenger.ui.fragments

import android.view.Menu
import android.view.MenuInflater
import com.trapeznikovdm.messenger.R
import com.trapeznikovdm.messenger.databinding.FragmentSettingsBinding


class SettingsFragment : BaseFragment(R.layout.fragment_settings) {

    private lateinit var binding: FragmentSettingsBinding

    override fun onResume() {
        super.onResume()
        setHasOptionsMenu(true)
    }


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        activity?.menuInflater?.inflate(R.menu.settings_action_menu, menu)

    }


}