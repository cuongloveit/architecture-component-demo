package com.example.architecturecomponentdemo.base

import android.arch.lifecycle.LifecycleRegistryOwner
import android.support.v7.app.AppCompatActivity
import com.example.architecturecomponentdemo.R
import dagger.android.support.HasSupportFragmentInjector

/**
 * Created by cuong on 7/14/17.
 * handling show message, dialog, change fragment,...
 */
abstract class BaseActivity: AppCompatActivity(), LifecycleRegistryOwner, HasSupportFragmentInjector {


    /**
     * change fragment
     */
    fun changeFragment(fragment : BaseFragment){
        supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container,fragment)
                .commit()
    }

    /**
     * show a message
     */
    fun showMessage(message: String){

    }


    /**
     * show dialog with a message and a ok button
     */
    fun showDialog(message: String){

    }

    /**
     * show or hide progressbar
     */
    fun showLoading(isShow: Boolean){

    }

}