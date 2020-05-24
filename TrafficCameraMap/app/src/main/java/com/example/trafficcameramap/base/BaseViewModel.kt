package com.example.trafficcameramap.base

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import com.example.trafficcameramap.di.AppModule
import com.example.trafficcameramap.di.DaggerViewModelInjector
import com.example.trafficcameramap.di.RepositoryModule
import com.example.trafficcameramap.di.ViewModelInjector
import com.example.trafficcameramap.ui.MapViewModel

abstract class BaseViewModel(application : Application) : AndroidViewModel(application) {

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
            is MapViewModel -> injector.inject(this)
        }
    }
}