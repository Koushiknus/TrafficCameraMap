package com.example.trafficcameramap

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.trafficcameramap.base.ViewModelFactory
import com.example.trafficcameramap.model.Cameras
import com.example.trafficcameramap.ui.MapViewModel
import com.example.trafficcameramap.utils.CustomInfoAdapter

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var mMapViewModel: MapViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
                .findFragmentById(R.id.map) as SupportMapFragment
        mMapViewModel = ViewModelProviders.of(this,ViewModelFactory(application)).get(MapViewModel::class.java)
        initialObservers()
        mapFragment.getMapAsync(this)
    }

    private fun initialObservers(){
        mMapViewModel.getTrafficImages("")
        mMapViewModel.mListOfCameras.observe(this, Observer {
            Log.v("ListOFObserversRcvd",it.size.toString())
            addMarkersToMap(it)
        })
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
    }

    private fun addMarkersToMap(cameraList : List<Cameras>){
        val intialPosition = LatLng(cameraList.get(0).location.latitude,cameraList.get(0).location.longitude)
        mMap.moveCamera(CameraUpdateFactory.newLatLng(intialPosition))
        for (i in cameraList){
            val marker = LatLng(i.location.latitude,i.location.longitude)
            val markerOptions = MarkerOptions().position(marker).title(i.image)
            mMap.addMarker(markerOptions)
        }
        mMap.setInfoWindowAdapter(CustomInfoAdapter(this))


    }
}
