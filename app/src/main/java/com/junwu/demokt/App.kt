package com.junwu.demokt

import android.content.Context
import android.util.Log
import androidx.multidex.MultiDex
import com.junwu.demokt.base.BaseApp
import com.scwang.smartrefresh.layout.SmartRefreshLayout
import com.scwang.smartrefresh.layout.api.RefreshLayout
import com.scwang.smartrefresh.layout.footer.ClassicsFooter
import com.scwang.smartrefresh.layout.header.ClassicsHeader

class App : BaseApp(){

    private val tag : String = "App"
    override fun onCreate() {
        super.onCreate()
        Log.e(tag, "onCreate: ", )
        initSmartHead()
        MultiDex.install(this)
    }

    private fun initSmartHead() {
        SmartRefreshLayout.setDefaultRefreshHeaderCreator { context: Context?, _: RefreshLayout? ->
            ClassicsHeader(context)
        }
        SmartRefreshLayout.setDefaultRefreshFooterCreator { context: Context?, _: RefreshLayout? ->
            ClassicsFooter(context)
        }
    }

}