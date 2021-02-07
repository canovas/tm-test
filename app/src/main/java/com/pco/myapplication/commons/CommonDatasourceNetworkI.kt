package com.pco.myapplication.commons

import com.pco.myapplication.conn.TMResult


internal interface CommonDatasourceNetworkI{
    suspend fun getSeniorCategory(): TMResult
    suspend fun getDayCenterCategory(): TMResult
}
