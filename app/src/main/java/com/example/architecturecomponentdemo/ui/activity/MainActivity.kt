package com.example.architecturecomponentdemo.ui.activity

import android.arch.lifecycle.ViewModelProvider
import android.os.Bundle
import android.support.v4.app.Fragment
import com.example.architecturecomponentdemo.R
import com.example.architecturecomponentdemo.base.BaseActivity
import com.example.architecturecomponentdemo.ui.fragment.MainFragment
import dagger.android.DispatchingAndroidInjector
import javax.inject.Inject

class MainActivity : BaseActivity() {

    @Inject lateinit var viewModelFactory: ViewModelProvider.Factory
    @Inject lateinit var androidInjector: DispatchingAndroidInjector<Fragment>
    private val lifecycleRegistry by lazy { android.arch.lifecycle.LifecycleRegistry(this) }

    override fun getLifecycle() = lifecycleRegistry

    override fun supportFragmentInjector() = androidInjector

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        changeFragment(MainFragment.newInstance())

    }
}
