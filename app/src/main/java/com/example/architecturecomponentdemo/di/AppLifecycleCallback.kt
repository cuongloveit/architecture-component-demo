package com.example.architecturecomponentdemo.di

import android.app.Application
import com.example.architecturecomponentdemo.IAppLifecycleCallbacks
import timber.log.Timber

/**
 * Created by cuong on 7/14/17.
 */
class AppLifecycleCallback : IAppLifecycleCallbacks{
    override fun onCreate(application: Application) {
        Timber.plant(Timber.DebugTree())
    }

    override fun onTerminate(application: Application) {

    }
}