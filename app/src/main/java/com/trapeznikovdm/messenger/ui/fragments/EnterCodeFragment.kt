package com.trapeznikovdm.messenger.ui.fragments

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthProvider
import com.trapeznikovdm.messenger.MainActivity
import com.trapeznikovdm.messenger.R
import com.trapeznikovdm.messenger.RegisterActivity
import com.trapeznikovdm.messenger.utils.AUTH
import com.trapeznikovdm.messenger.utils.AppTextWatcher
import com.trapeznikovdm.messenger.utils.replaceActivity
import com.trapeznikovdm.messenger.utils.showToast
import kotlinx.android.synthetic.main.fragment_enter_code.*

class EnterCodeFragment(val phoneNumber: String, val id: String) :
    BaseFragment(R.layout.fragment_enter_code) {


    override fun onStart() {
        super.onStart()
        (activity as RegisterActivity).title = phoneNumber
        register_input_code.addTextChangedListener(AppTextWatcher {
            val string = register_input_code.text.toString()
            if (string.length == 6) {
                enterCode()
            }
        })

    }

    private fun enterCode() {
        val code = register_input_code.text.toString()
        val credential = PhoneAuthProvider.getCredential(id, code)
        AUTH.signInWithCredential(credential).addOnCompleteListener{
            if(it.isSuccessful){
                showToast("Welcome!")
                (activity as RegisterActivity).replaceActivity(MainActivity())
            } else {
                showToast(it.exception?.message.toString())
            }
        }
    }
}