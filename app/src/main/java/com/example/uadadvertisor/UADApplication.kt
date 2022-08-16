package com.example.uadadvertisor

import android.app.Application
import android.content.Context
import com.raywenderlich.android.petsave.common.data.api.interceptors.Logger
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class UADApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        appContext = applicationContext
        instance = this
        initLogger()

    }


    private fun initLogger() {
        Logger.init()
    }
    companion object {
        lateinit var instance: UADApplication
        lateinit  var appContext: Context
    }
}

