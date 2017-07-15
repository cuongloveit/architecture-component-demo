package com.example.architecturecomponentdemo.base

import android.content.Context
import com.example.architecturecomponentdemo.api.MyAPI
import org.junit.Before
import org.junit.runner.RunWith
import org.robolectric.RuntimeEnvironment

/**
 * Created by cuong on 7/15/17.
 */

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