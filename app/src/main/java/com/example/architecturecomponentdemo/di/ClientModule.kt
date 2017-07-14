package com.example.architecturecomponentdemo.di

import com.example.architecturecomponentdemo.api.MyAPI
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * Created by cuong on 7/14/17.
 */
@Module
class ClientModule {


    @Singleton @Provides
    fun providesOkHttp(): OkHttpClient = OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor()
                    .apply { level = HttpLoggingInterceptor.Level.BODY })
            .build()

    @Singleton @Provides
    fun provideRetrofit(oktHttpClient: OkHttpClient): Retrofit
            = Retrofit.Builder()
            .client(oktHttpClient)
            .baseUrl("https://api.github.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()

    @Singleton @Provides
    fun provideAPIService(retrofit: Retrofit): MyAPI
            = retrofit.create(MyAPI::class.java)

}