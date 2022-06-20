package com.trapeznikovdm.messenger.ui.fragments

import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import com.trapeznikovdm.messenger.MainActivity
import com.trapeznikovdm.messenger.R
import com.trapeznikovdm.messenger.utils.*
import kotlinx.android.synthetic.main.fragment_change_id.*
import kotlinx.coroutines.test.withTestContext

class ChangeUserNameFragment : ChangeBaseFragment(R.layout.fragment_change_id) {

    lateinit var mNewUserName: String

    override fun onResume() {
        super.onResume()
        settings_input_username.hint = USER.username
    }


    override fun change() {
        mNewUserName = settings_input_username.text.toString()
        if (mNewUserName.isEmpty()) {
            showToast("Поле пустое")
        } else {
            REF_DATABASE_ROOT.child(NODE_USERNAMES)
                .addListenerForSingleValueEvent(AppValueEventListener {
                    if (it.hasChild(mNewUserName)) {
                        showToast("Такой пользователь уже есть")
                    } else {
                        changeUserName()
                    }
                })

        }
    }

    private fun changeUserName() {
        REF_DATABASE_ROOT.child(NODE_USERNAMES).child(mNewUserName).setValue(UID)
            .addOnCompleteListener {
                if (it.isSuccessful) {
                    updateCurrentUserName()
                }
            }
    }

    private fun updateCurrentUserName() {
        REF_DATABASE_ROOT.child(NODE_USERS).child(UID).child(CHILD_USER_NAME).setValue(mNewUserName)
            .addOnCompleteListener {
                if (it.isSuccessful) {
                    showToast("Данные обновлены")
                    deleteOldUserName()
                } else {
                    showToast(it.exception?.message.toString())
                }
            }
    }

    private fun deleteOldUserName() {
        REF_DATABASE_ROOT.child(NODE_USERNAMES).child(USER.username).removeValue()
            .addOnCompleteListener {
                if (it.isSuccessful) {
                    showToast("Данные обновлены")
                    fragmentManager?.popBackStack()
                    USER.username = mNewUserName
                } else {
                    showToast(it.exception?.message.toString())
                }
            }
    }
}