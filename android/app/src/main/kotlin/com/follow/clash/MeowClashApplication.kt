package com.follow.clash

import android.app.Application
import android.content.Context

class MeowClashApplication : Application() {
    companion object {
        private lateinit var instance: MeowClashApplication
        fun getAppContext(): Context = instance.applicationContext
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}
