package com.shadowfx.shadowfxmoviefinder

import android.app.Application
import androidx.lifecycle.ViewModelProvider
import com.shadowfx.shadowfxmoviefinder.di.AppComponent
import com.shadowfx.shadowfxmoviefinder.di.AppModule
import com.shadowfx.shadowfxmoviefinder.di.MainActivityModule
import com.shadowfx.shadowfxmoviefinder.di.ViewModelModule
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
interface TestAppComponent : AndroidInjector<TestApp> {
    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder
        fun build(): TestAppComponent
    }

    override fun inject(myApp: TestApp?)
    fun vmFactory(): ViewModelProvider.Factory?
}