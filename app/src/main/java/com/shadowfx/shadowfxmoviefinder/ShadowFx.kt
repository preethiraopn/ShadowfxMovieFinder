package com.shadowfx.shadowfxmoviefinder

import android.app.Activity
import android.app.Application
import androidx.multidex.MultiDex
import com.shadowfx.shadowfxmoviefinder.di.AppInjector
import com.shadowfx.shadowfxmoviefinder.testing.OpenForTesting

import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject


@OpenForTesting
class ShadowFx : Application() , HasAndroidInjector {

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    companion object{
        lateinit var instance: ShadowFx
            private set
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        AppInjector.init(this)
        MultiDex.install(this)
    }


    override fun androidInjector(): AndroidInjector<Any> {
        return dispatchingAndroidInjector as AndroidInjector<Any>
    }


}
