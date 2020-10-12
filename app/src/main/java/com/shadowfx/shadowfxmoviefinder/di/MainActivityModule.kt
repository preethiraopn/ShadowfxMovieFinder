package com.shadowfx.shadowfxmoviefinder.di


import com.shadowfx.shadowfxmoviefinder.ui.home.HomeActivity
import com.shadowfx.shadowfxmoviefinder.ui.moviedetail.MovieDetailScrollingActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Suppress("unused")
@Module
abstract class MainActivityModule {

    @ContributesAndroidInjector
    abstract fun contributeHomeActivity(): HomeActivity


    @ContributesAndroidInjector
    abstract fun contributeMovieDetailActivity(): MovieDetailScrollingActivity
}


//ContributesAndroidInjector
//@Component.Builder
///@Singleton
//AndroidInjectionModule

//@MustBeDocumented
//@Target(
//    AnnotationTarget.FUNCTION,
//    AnnotationTarget.PROPERTY_GETTER,
//    AnnotationTarget.PROPERTY_SETTER
//)
//@Retention(AnnotationRetention.RUNTIME)
//@MapKey

//    @Provides

//    @ContributesAndroidInjector