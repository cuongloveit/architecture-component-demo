package com.example.architecturecomponentdemo.ui.fragment

import android.arch.lifecycle.LifecycleRegistry
import android.arch.lifecycle.LifecycleRegistryOwner
import android.support.v4.app.Fragment
import com.example.architecturecomponentdemo.di.Injectable

/**
 * Created by cuong on 7/14/17.
 */
class MainFragment : Fragment(), LifecycleRegistryOwner, Injectable {
    private val lifecycleRegistry by lazy { LifecycleRegistry(this) }
    override fun getLifecycle()  = lifecycleRegistry


    companion object {
        fun newInstance() = MainFragment()
    }
}
