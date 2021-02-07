package com.pco.myapplication.commons

import com.pco.myapplication.conn.TMResult

internal interface CommonUseCasesRepository {
    suspend fun getSeniorCategory(): TMResult
    suspend fun getDayCenterCategory(): TMResult
}
