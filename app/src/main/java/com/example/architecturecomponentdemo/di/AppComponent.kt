package com.example.architecturecomponentdemo.di

import com.example.architecturecomponentdemo.MyAppplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

/**
 * Created by cuong on 7/14/17.
 */
@Singleton
@Component(modules = arrayOf(
        AndroidSupportInjectionModule::class,
        AppModule::class,
        UiModule::class)
)
interface AppComponent : AndroidInjector<MyAppplication> {
    @Component.Builder
    interface Builder {
        @BindsInstance fun application(application: MyAppplication): Builder
        fun build(): AppComponent
    }

    override fun inject(instance: MyAppplication) {
    }
}