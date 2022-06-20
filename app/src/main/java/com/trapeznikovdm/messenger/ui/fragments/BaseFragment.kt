package com.trapeznikovdm.messenger.ui.fragments

import androidx.fragment.app.Fragment
import com.trapeznikovdm.messenger.MainActivity

open class BaseFragment(layout: Int): Fragment(layout) {
    override fun onStart() {
        super.onStart()
        (activity as MainActivity).appDrawer.disableDriver()

    }

    override fun onStop() {
        super.onStop()
        (activity as MainActivity).appDrawer.enableDriver()
    }
}