package com.example.trafficcameramap.di

import com.example.trafficcameramap.ui.MapViewRepository
import dagger.Module
import dagger.Provides
import dagger.Reusable

@Module
// Safe here as we are dealing with a Dagger 2 module
@Suppress("unused")
object RepositoryModule {

    @Provides
    @Reusable
    @JvmStatic
    internal fun provideMapViewRepository() : MapViewRepository{
        return MapViewRepository()
    }
}