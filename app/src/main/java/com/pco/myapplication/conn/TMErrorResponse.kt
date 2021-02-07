package com.pco.myapplication.conn


import com.google.gson.annotations.SerializedName


data class TMErrorResponse(
    @SerializedName("Code")
    var code: Int? = null,
    @SerializedName("Message")
    var message: String? = null,
    @SerializedName("Severity")
    var severity: Int?= null,
    @SerializedName("Category")
    var category: Int?= null,
    @field:SerializedName("MinTime")
    var minTime: Int?= null,
    @field:SerializedName("MaxTime")
    var maxTime: Int?= null
)
