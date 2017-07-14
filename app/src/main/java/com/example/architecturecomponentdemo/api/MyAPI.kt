package com.example.architecturecomponentdemo.api

import com.example.architecturecomponentdemo.api.entity.SearchResponse
import io.reactivex.Flowable
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by cuong on 7/14/17.
 */
interface MyAPI {
    @GET("search/repositories")
    fun searchRepository(@Query("q") keyword: String): Flowable<SearchResponse>

}