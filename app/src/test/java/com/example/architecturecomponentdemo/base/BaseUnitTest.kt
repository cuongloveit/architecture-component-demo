package com.example.architecturecomponentdemo.base

import android.content.Context
import com.example.architecturecomponentdemo.BuildConfig
import com.example.architecturecomponentdemo.api.MyAPI
import org.junit.Before
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment
import org.robolectric.annotation.Config

/**
 * Created by cuong on 7/15/17.
 */
@RunWith(RobolectricTestRunner::class)
@Config( constants = BuildConfig::class,
        application = TestApplication::class,
        sdk = intArrayOf(21))
abstract class BaseUnitTest {


    @Before
    fun setup() {


    }

    fun getMyApi(): MyAPI {
        return application().myAPI
    }

    fun context(): Context {
        return RuntimeEnvironment.application
    }

    fun application(): TestApplication {
        return RuntimeEnvironment.application as TestApplication
    }


}