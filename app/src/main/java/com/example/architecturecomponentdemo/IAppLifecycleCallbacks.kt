package com.example.architecturecomponentdemo

import android.app.Application

/**
 * Created by cuong on 7/14/17.
 */
interface IAppLifecycleCallbacks {
    fun onCreate(application: Application)

    fun onTerminate(application: Application)
}