package com.example.trafficcameramap.ui

import android.app.Application
import android.util.Log
import androidx.lifecycle.viewModelScope
import com.example.trafficcameramap.base.BaseViewModel
import com.example.trafficcameramap.base.Constants
import com.example.trafficcameramap.network.ApiMethods
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject


class MapViewModel (application: Application) : BaseViewModel(application){
    @set: Inject
    var apiMethods: ApiMethods? = null

    @set:Inject
    var mMapViewRepository : MapViewRepository? = null


    fun getTrafficImages(dateTime: String){

        viewModelScope.launch {
            val result = mMapViewRepository?.getTrafficImages(getCurrentDate())
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