package com.example.projecttask1parliamentmemberview

import android.app.Application
import android.content.Context

/**
 * Name: Son Dang (2012177)
 * Date: 9.10.2021
 */

class MyApp: Application() {
    companion object {
        lateinit var appContext: Context
    }

    override fun onCreate() {
        super.onCreate()
        appContext = applicationContext
    }
}