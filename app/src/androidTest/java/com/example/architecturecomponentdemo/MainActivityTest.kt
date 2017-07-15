package com.example.architecturecomponentdemo

import com.example.architecturecomponentdemo.ui.activity.MainActivity
import com.fernandocejas.android.sample.ui.framework.AcceptanceTest
import org.junit.Test

/**
 * Created by cuong on 7/15/17.
 */
class MainActivityTest: AcceptanceTest<MainActivity>(MainActivity::class.java){
    @Test
    fun searchRepository(){
        events.typeOnEditText(R.id.edtSearch,"kotlin")
        events.clickOnView(R.id.btnSearch)
    }
}