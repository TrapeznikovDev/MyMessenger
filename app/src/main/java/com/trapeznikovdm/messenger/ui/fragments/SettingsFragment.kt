package com.trapeznikovdm.messenger.ui.fragments

import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import com.trapeznikovdm.messenger.MainActivity
import com.trapeznikovdm.messenger.R
import com.trapeznikovdm.messenger.RegisterActivity
import com.trapeznikovdm.messenger.utils.AUTH
import com.trapeznikovdm.messenger.utils.USER
import com.trapeznikovdm.messenger.utils.replaceActivity
import com.trapeznikovdm.messenger.utils.replaceFragment
import kotlinx.android.synthetic.main.fragment_settings.*


class SettingsFragment : BaseFragment(R.layout.fragment_settings) {



    override fun onResume() {
        super.onResume()
        setHasOptionsMenu(true)
        initFields()
    }



    private fun initFields() {
        about_user.text = USER.bio
        user_name.text = USER.fullname
        user_phone_number.text = USER.phone
        user_login.text = USER.username
        user_status.text = USER.status
        login_btn_change.setOnClickListener {replaceFragment(ChangeUserNameFragment())}
        about_user_btn_change.setOnClickListener {replaceFragment(ChangeBioFragment())}
    }


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        activity?.menuInflater?.inflate(R.menu.settings_action_menu, menu)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.settings_btn_exit -> {
                AUTH.signOut()
                (activity as MainActivity).replaceActivity(RegisterActivity())
            }
            R.id.settings_menu_change_name -> replaceFragment(ChangeNameFragment())
        }
        return true
    }
}