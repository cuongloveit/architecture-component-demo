package com.example.architecturecomponentdemo.viewmodel

import android.arch.lifecycle.MutableLiveData
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by cuong on 7/14/17.
 */
@Singleton
class SearchViewModel @Inject constructor() {

    var keyword = MutableLiveData<String>()
}