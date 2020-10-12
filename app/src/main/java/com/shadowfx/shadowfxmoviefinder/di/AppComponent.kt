package com.shadowfx.shadowfxmoviefinder.di

import android.app.Application

import com.shadowfx.shadowfxmoviefinder.ShadowFx

import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        AppModule::class,
        MainActivityModule::class]
)
interface AppComponent : AndroidInjector<ShadowFx> {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder
        fun build(): AppComponent
    }

    override fun inject(shadowx: ShadowFx)
}
