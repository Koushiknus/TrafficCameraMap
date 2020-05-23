package com.example.trafficcameramap.model

data class TrafficImageResponse (

    val items : List<Items>,
    val api_info : Api_info
)

data class Items (

    val timestamp : String,
    val cameras : List<Cameras>
)


data class Cameras (

    val timestamp : String,
    val image : String,
    val location : Location,
    val camera_id : Int,
    val image_metadata : Image_metadata
)

data class Location (

    val latitude : Double,
    val longitude : Double
)


data class Api_info (

    val status : String
)


data class Image_metadata (

    val height : Int,
    val width : Int,
    val md5 : String
)