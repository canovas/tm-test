package com.pco.myapplication.networking.responses

import com.google.gson.annotations.SerializedName
import java.util.ArrayList

data class DataResponse (

    @SerializedName("@graph")
    val graphList: ArrayList<GraphData>? = null)
