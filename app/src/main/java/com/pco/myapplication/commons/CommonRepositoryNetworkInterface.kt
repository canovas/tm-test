package com.pco.myapplication.commons

import com.pco.myapplication.conn.TMResult

interface CommonRepositoryNetworkInterface {
    suspend fun getSeniorCategory(): TMResult
    suspend fun getDayCenterCategory(): TMResult
}
