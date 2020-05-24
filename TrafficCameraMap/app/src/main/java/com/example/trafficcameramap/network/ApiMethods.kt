package com.example.trafficcameramap.network

import com.example.trafficcameramap.model.TrafficImageResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiMethods {
    @GET("traffic-images?")
    fun getTrafficImages(@Query("date_time")dateTime: String) : Call<TrafficImageResponse>
}