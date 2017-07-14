package com.example.architecturecomponentdemo.di

import com.example.architecturecomponentdemo.IAppLifecycleCallbacks
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by cuong on 7/14/17.
 */

@Module(includes = arrayOf(ClientModule::class))
class AppModule {

    @Singleton @Provides
    fun provideAppLifecycleCallbacks(): IAppLifecycleCallbacks = AppLifecycleCallback()

}