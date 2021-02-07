package com.pco.myapplication.utils

import com.pco.myapplication.conn.TMErrorResponse
import com.pco.myapplication.conn.TMErrors
import com.pco.myapplication.conn.TMResult

internal fun generateResultError(error: TMErrors = TMErrors.UNHANDLED_ERROR) =
    TMResult.Error(TMErrorResponse(message = error.description))


internal fun generateError(code: Int? = null,
                           message: String? = null,
                           severity: Int?= null,
                           category: Int?= null,
                           minTime: Int?= null,
                           maxTime: Int?= null): TMErrorResponse {
    return  TMErrorResponse(code,message,severity,category,minTime,maxTime)
}

internal fun generateTypeError(msg: String?):Int {
    var error = TMErrors.NOT_CONNECTED_ERROR
    val msg = msg ?: ""
    if (!msg.contains(MSG_NOT_CONN, true)) {
        error = TMErrors.UNHANDLED_ERROR
    }
    return error.ordinal
}