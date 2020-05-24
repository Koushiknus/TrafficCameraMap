package com.example.trafficcameramap.di

import com.example.trafficcameramap.ui.MapViewRepository
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [(AppModule::class), RepositoryModule::class])
interface RepositoryInjector {

    fun inject(mapViewRepository: MapViewRepository)

    @Component.Builder
    interface Builder {
        fun build(): RepositoryInjector
        fun appModule(appModule: AppModule): Builder
        fun repositoryModule(repositoryModule: RepositoryModule): Builder
    }
}