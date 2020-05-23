package com.example.trafficcameramap.base

import com.example.trafficcameramap.di.AppModule
import com.example.trafficcameramap.di.DaggerRepositoryInjector
import com.example.trafficcameramap.di.RepositoryInjector
import com.example.trafficcameramap.di.RepositoryModule

abstract class BaseRepository {

    private val injector : RepositoryInjector = DaggerRepositoryInjector
        .builder()
        .appModule(AppModule)
        .repositoryModule(RepositoryModule)
        .build()

    init {
        inject()
    }

    private fun inject(){
        when(this){
        }
    }
}