package com.example.architecturecomponentdemo.di

import android.arch.lifecycle.ViewModelProvider
import com.example.architecturecomponentdemo.MainActivity
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by cuong on 7/14/17.
 */
@Module
internal abstract class UiModule {

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @ContributesAndroidInjector(modules = arrayOf(MainModule::class))
    internal abstract fun contributeMainActivity(): MainActivity

}