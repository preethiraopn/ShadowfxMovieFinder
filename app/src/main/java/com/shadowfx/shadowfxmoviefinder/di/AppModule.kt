package com.shadowfx.shadowfxmoviefinder.di

import android.app.Application
import com.shadowfx.shadowfxmoviefinder.data.network.ApiInterface
import com.shadowfx.shadowfxmoviefinder.data.network.NetworkConnectionInterceptor


import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

import javax.inject.Singleton


@Module(includes = [ViewModelModule::class])
class AppModule {
    @Singleton
    @Provides
    fun provideMindValleyService(networkConnectionInterceptor: NetworkConnectionInterceptor): ApiInterface {
        val okkHttpclient = OkHttpClient.Builder()
            .addInterceptor(networkConnectionInterceptor)
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .connectTimeout(1, TimeUnit.MINUTES)
            .readTimeout(30, TimeUnit.SECONDS)
            .build()

        return Retrofit.Builder()
            .client(okkHttpclient)
            .baseUrl("https://www.omdbapi.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiInterface::class.java)
    }

    @Singleton
    @Provides
    fun provideNetworkInterceptors(app: Application): NetworkConnectionInterceptor {
        return NetworkConnectionInterceptor(app)
    }


}
