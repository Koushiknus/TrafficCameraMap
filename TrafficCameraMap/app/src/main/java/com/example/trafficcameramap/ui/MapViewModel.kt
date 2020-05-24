package com.example.trafficcameramap.ui

import android.app.Application
import android.util.Log
import androidx.lifecycle.viewModelScope
import com.example.trafficcameramap.base.BaseViewModel
import com.example.trafficcameramap.network.ApiMethods
import kotlinx.coroutines.launch
import javax.inject.Inject

class MapViewModel (application: Application) : BaseViewModel(application){
    @set: Inject
    var apiMethods: ApiMethods? = null

    @set:Inject
    var mMapViewRepository : MapViewRepository? = null


    fun getTrafficImages(dateTime: String){

        viewModelScope.launch {
            val result = mMapViewRepository?.getTrafficImages("2020-05-24T01:01:01")
            Log.v("ResultReceived",result.toString())
        }
    }

}