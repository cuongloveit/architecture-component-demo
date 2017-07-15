package com.example.architecturecomponentdemo.di

import android.arch.lifecycle.ViewModel
import com.example.architecturecomponentdemo.ui.fragment.MainFragment
import com.example.architecturecomponentdemo.viewmodel.MainViewModel
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

/**
 * Created by cuong on 7/14/17.
 */
@Module
 abstract class MainModule {

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun bindMainViewModel(viewModel: MainViewModel): ViewModel

    @ContributesAndroidInjector
    abstract fun contributeMainFragment(): MainFragment

}