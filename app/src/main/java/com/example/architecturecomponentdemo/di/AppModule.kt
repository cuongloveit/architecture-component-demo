package com.example.architecturecomponentdemo.di

import dagger.Module

/**
 * Created by cuong on 7/14/17.
 */

@Module(includes = arrayOf(DataModule::class))
class AppModule {

//    @Singleton @Provides
//    fun provideAppLifecycleCallbacks(): AppLifecycleCallbacks = DebugAppLifecycleCallbacks()

}