package com.example.trafficcameramap.base

import android.app.Application
import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.trafficcameramap.ui.MapViewModel
import javax.inject.Singleton

@Suppress("UNCHECKED_CAST")
@Singleton
class ViewModelFactory(context: Application) : ViewModelProvider.Factory {

    private val mContext = context

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(MapViewModel::class.java))
            return MapViewModel(mContext) as T
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}