package com.example.trafficcameramap.ui

import android.app.Application
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.trafficcameramap.base.BaseViewModel
import com.example.trafficcameramap.base.Constants
import com.example.trafficcameramap.model.Cameras
import com.example.trafficcameramap.network.ApiMethods
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject
import kotlin.collections.ArrayList


class MapViewModel (application: Application) : BaseViewModel(application){
    @set: Inject
    var apiMethods: ApiMethods? = null

    @set:Inject
    var mMapViewRepository : MapViewRepository? = null

     var mListOfCameras = MutableLiveData<List<Cameras>>()


    fun getTrafficImages(dateTime: String){

        viewModelScope.launch {
            val result = mMapViewRepository?.getTrafficImages(getCurrentDate())
            mListOfCameras.value = result?.items?.get(0)?.cameras
            Log.v("ResultReceived",result.toString())
        }
    }

   private fun getCurrentDate(): String {
        val dateFormat = SimpleDateFormat(Constants.DATE_TIME_FORMAT)
        dateFormat.setTimeZone(TimeZone.getTimeZone(Constants.TIME_ZONE))
        val today = Calendar.getInstance().time
        return dateFormat.format(today)
    }

}