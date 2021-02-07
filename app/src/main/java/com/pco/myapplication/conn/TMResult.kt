package com.pco.myapplication.conn

enum class TMErrors(val description: String) {
    UNHANDLED_ERROR("UNHANDLED_ERROR") ,
    NOT_CONNECTED_ERROR("NO_CONNECTION")
}

sealed class TMResult {
    data class Success(val data: Any?): TMResult()
    data class Error(val error: Any?): TMResult()
}