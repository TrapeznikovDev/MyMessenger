package com.trapeznikovdm.messenger

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.google.firebase.auth.FirebaseAuth
import com.trapeznikovdm.messenger.databinding.ActivityMainBinding
import com.trapeznikovdm.messenger.ui.fragments.ChatsFragment
import com.trapeznikovdm.messenger.ui.objects.AppDrawer
import com.trapeznikovdm.messenger.utils.AUTH
import com.trapeznikovdm.messenger.utils.replaceActivity
import com.trapeznikovdm.messenger.utils.replaceFragment

class MainActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityMainBinding
    private lateinit var appDrawer: AppDrawer
    private lateinit var mToolbar: Toolbar



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
    }

    override fun onStart() {
        super.onStart()
        initFields()
        initFunc()
    }

    private fun initFunc() {
        if(AUTH.currentUser!=null){
            setSupportActionBar(mToolbar)
            appDrawer.create()
            replaceFragment(ChatsFragment())
        }else{
            replaceActivity(RegisterActivity())
        }
    }

    private fun initFields() {
        mToolbar = mBinding.mainToolBar
        appDrawer = AppDrawer(this, mToolbar)
        AUTH = FirebaseAuth.getInstance()
    }
}