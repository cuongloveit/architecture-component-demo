package com.example.architecturecomponentdemo.viewmodel

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.example.architecturecomponentdemo.api.MyAPI
import com.example.architecturecomponentdemo.api.entity.Repository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created by cuong on 7/14/17.
 */
class MainViewModel @Inject constructor(private val myAPI: MyAPI) : ViewModel() {


    val repositories = MutableLiveData<List<Repository>>()
    val error = MutableLiveData<String>()
    val isLoading = MutableLiveData<Boolean>()

    fun searchRespository(keyword: String) {
        isLoading.value = true
        myAPI.searchRepository(keyword)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ data ->
                    isLoading.value = false
                    repositories.value = data.repositories
                }, { e ->
                    error.value = e.message

                })

    }

}