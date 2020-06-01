package com.example.trafficcameramap.utils

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import com.example.trafficcameramap.R
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.model.Marker
import com.squareup.picasso.Picasso

class CustomInfoAdapter : GoogleMap.InfoWindowAdapter {

    private  var mWindow : View
    private  var mContext : Context

    constructor(context: Context){
        mContext = context
        mWindow = LayoutInflater.from(context).inflate(R.layout.custom_info_window,null)
    }

    private fun renderWindowText(marker: Marker?,view: View){

        val title = marker?.title
        val imgView = view.findViewById<ImageView>(R.id.cameraView)
        Log.v("CameraImageInfo",title)
        Picasso.get().load(title).into(imgView)


    }

    override fun getInfoContents(p0: Marker?): View? {
        renderWindowText(p0,mWindow)
        return  mWindow
    }

    override fun getInfoWindow(p0: Marker?): View? {
        renderWindowText(p0,mWindow)
        return  mWindow
    }
}