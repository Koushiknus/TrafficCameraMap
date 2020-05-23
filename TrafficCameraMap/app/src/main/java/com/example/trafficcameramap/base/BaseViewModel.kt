package com.example.trafficcameramap.base

import androidx.lifecycle.ViewModel
import com.example.trafficcameramap.di.AppModule
import com.example.trafficcameramap.di.DaggerViewModelInjector
import com.example.trafficcameramap.di.RepositoryModule
import com.example.trafficcameramap.di.ViewModelInjector

abstract class BaseViewModel : ViewModel() {

    private val injector : ViewModelInjector = DaggerViewModelInjector
        .builder()
        .appModule(AppModule)
        .repositoryModule(RepositoryModule)
        .build()

    init {
        inject()
    }

    private fun inject(){
        when (this) {
        }
    }
}