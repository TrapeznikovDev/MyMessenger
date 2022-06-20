package com.trapeznikovdm.messenger.ui.fragments

import com.trapeznikovdm.messenger.R
import com.trapeznikovdm.messenger.utils.*
import kotlinx.android.synthetic.main.fragment_change_name.*

class ChangeNameFragment : ChangeBaseFragment(R.layout.fragment_change_name) {

    override fun onResume() {
        super.onResume()
        initFullnameList()
    }

    private fun initFullnameList() {
        val fullNameList = USER.fullname.split(" ")
        if (fullNameList.size > 1) {
            settings_input_name.hint = fullNameList[0]
            settings_input_surname.hint = fullNameList[1]
        } else settings_input_name.hint = fullNameList[0]
    }

    override fun change() {
        val name = settings_input_name.text.toString()
        val surname = settings_input_surname.text.toString()
        if (name.isEmpty()) {
            showToast("Имя не может быть пустым")
        } else {
            val fullName = "$name $surname"
            REF_DATABASE_ROOT.child(NODE_USERS).child(UID).child(CHILD_FULL_NAME).setValue(fullName)
                .addOnCompleteListener {
                    if (it.isSuccessful) {
                        showToast("Данные обновлены")
                        USER.fullname = fullName
                        fragmentManager?.popBackStack()
                    }
                }
        }
    }

}