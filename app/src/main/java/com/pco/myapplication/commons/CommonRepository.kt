package com.pco.myapplication.commons

import com.pco.myapplication.conn.TMResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

internal class CommonRepository (private val network: CommonDatasourceNetworkI):
    CommonUseCasesRepository {

    override suspend fun getSeniorCategory(): TMResult =
        withContext(Dispatchers.IO) {
            when (val result = network.getSeniorCategory()) {
                is TMResult.Success ->{
                    return@withContext result
                }
                is TMResult.Error ->{  return@withContext result}
            }
        }

    override suspend fun getDayCenterCategory(): TMResult =
        withContext(Dispatchers.IO) {
            when (val result = network.getDayCenterCategory()) {
                is TMResult.Success ->{
                    return@withContext result
                }
                is TMResult.Error ->{  return@withContext result}
            }
        }
}

