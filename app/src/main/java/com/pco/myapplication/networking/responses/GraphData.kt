package com.pco.myapplication.networking.responses

import com.google.gson.annotations.SerializedName

data class GraphData (
    @SerializedName("id")
    val id: String? = null,
    @SerializedName("title")
    val title: String? = null
)
