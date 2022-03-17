package com.junwu.demokt.base

import android.app.Application
import android.content.Context

open class BaseApp : Application() {

    override fun onCreate() {
        super.onCreate()
        sBaseApplication = this
    }

    companion object {
        lateinit var sBaseApplication : BaseApp
        fun getContext() : Context {
            return sBaseApplication
        }
    }

}