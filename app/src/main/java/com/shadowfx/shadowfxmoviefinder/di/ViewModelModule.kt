package com.shadowfx.shadowfxmoviefinder.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.shadowfx.shadowfxmoviefinder.ui.home.HomeViewModel
import com.shadowfx.shadowfxmoviefinder.ui.moviedetail.MovieDetailViewModel

import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    abstract fun bindHomeViewModel(homeViewModel: HomeViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(MovieDetailViewModel::class)
    abstract fun bindMovieDetailModel(movieDetailModel:  MovieDetailViewModel): ViewModel

    @Binds
    abstract fun bindViewModelFactory(factory: MindValleyViewModelFactory): ViewModelProvider.Factory
}
