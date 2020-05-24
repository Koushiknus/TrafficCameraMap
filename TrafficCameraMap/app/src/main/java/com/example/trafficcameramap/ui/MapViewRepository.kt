package com.example.trafficcameramap.ui

import com.example.trafficcameramap.base.BaseRepository
import com.example.trafficcameramap.model.TrafficImageResponse
import com.example.trafficcameramap.network.ApiMethods
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

class MapViewRepository : BaseRepository(){
    @set: Inject
    var mApiMethods : ApiMethods? = null

    suspend fun getTrafficImages(dateTime: String) : TrafficImageResponse?{

        return suspendCoroutine { continuation ->
            mApiMethods?.let {
                it.getTrafficImages(dateTime).enqueue(object : Callback<TrafficImageResponse>{
                    override fun onFailure(call: Call<TrafficImageResponse>, t: Throwable) {
                        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                    }

                    override fun onResponse(
                        call: Call<TrafficImageResponse>,
                        response: Response<TrafficImageResponse>
                    ) {
                        try{
                            val response = response.body() as TrafficImageResponse
                            continuation.resume(response)
                        }catch (e: Exception){
                            continuation.resume(null)
                        }
                    }
                })
            }

        }
    }

}