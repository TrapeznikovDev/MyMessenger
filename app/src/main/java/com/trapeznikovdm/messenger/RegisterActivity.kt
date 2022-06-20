package com.trapeznikovdm.messenger

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import com.trapeznikovdm.messenger.databinding.ActivityRegisterBinding
import com.trapeznikovdm.messenger.ui.fragments.EnterPhoneNumberFragment
import com.trapeznikovdm.messenger.utils.initFirebase
import com.trapeznikovdm.messenger.utils.replaceFragment

class RegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding
    private lateinit var toolBar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initFirebase()
    }

    override fun onStart() {
        super.onStart()
        toolBar = binding.registerToolBar
        setSupportActionBar(toolBar)
        title = "Ваш телефон"
       replaceFragment(EnterPhoneNumberFragment())
    }
}