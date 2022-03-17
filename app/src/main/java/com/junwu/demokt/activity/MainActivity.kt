package com.junwu.demokt.activity

import android.os.Bundle
import android.util.Log
import com.junwu.demokt.R
import com.junwu.demokt.base.BaseVmActivity

class MainActivity : BaseVmActivity() {
    private val tag : String = "MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.e(tag, "onCreate: ")
    }

    override fun init(savedInstanceState: Bundle?) {
    }

    override fun getLayoutId() = R.layout.activity_main
}