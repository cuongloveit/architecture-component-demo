package com.example.architecturecomponentdemo

import com.example.architecturecomponentdemo.api.MyAPI
import com.example.architecturecomponentdemo.di.DaggerAppComponent
import com.example.architecturecomponentdemo.di.applyAutoInjector
import dagger.android.support.DaggerApplication
import javax.inject.Inject

/**
 * Created by cuong on 7/14/17.
 */
open class MyApplication : DaggerApplication() {

    @Inject lateinit var appLifecycleCallbacks: IAppLifecycleCallbacks
    @Inject lateinit var myAPI: MyAPI

    override fun applicationInjector() = DaggerAppComponent.builder()
            .application(this)
            .build()

    override fun onCreate() {
        super.onCreate()
        applyAutoInjector()
        appLifecycleCallbacks.onCreate(this)
    }

    override fun onTerminate() {
        appLifecycleCallbacks.onTerminate(this)
        super.onTerminate()
    }
}