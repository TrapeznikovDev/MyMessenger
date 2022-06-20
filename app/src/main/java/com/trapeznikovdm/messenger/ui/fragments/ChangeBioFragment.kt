package com.trapeznikovdm.messenger.ui.fragments

import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import com.trapeznikovdm.messenger.MainActivity
import com.trapeznikovdm.messenger.R
import com.trapeznikovdm.messenger.utils.*
import kotlinx.android.synthetic.main.fragment_change_bio.*


class ChangeBioFragment : ChangeBaseFragment(R.layout.fragment_change_bio) {

    override fun onResume() {
        super.onResume()
        setHasOptionsMenu(true)
        settings_input_bio.hint = USER.bio
    }

    override fun change() {
        super.change()
        val newBio = settings_input_bio.text.toString()
        REF_DATABASE_ROOT.child(NODE_USERS).child(UID).child(CHILD_BIO).setValue(newBio)
            .addOnCompleteListener {
                if(it.isSuccessful){
                    showToast("Данные обновлены")
                    USER.bio = newBio
                    fragmentManager?.popBackStack()
                    //
                }
            }
    }
}