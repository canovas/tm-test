package com.pco.myapplication.commons

import com.google.gson.Gson
import com.pco.myapplication.conn.TMResult
import com.pco.myapplication.conn.Connector
import com.pco.myapplication.networking.responses.DataResponse
import com.pco.myapplication.utils.ACTION_OP1
import com.pco.myapplication.utils.ACTION_OP2
import com.pco.myapplication.utils.SERVER
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

internal  object CommonRepositoryNetwork: CommonRepositoryNetworkInterface {

    override suspend fun getSeniorCategory(): TMResult =
        withContext(Dispatchers.IO) {
            when(val result= Connector.callGet(SERVER+ACTION_OP1)){
                is TMResult.Success ->{
                    try {
                        val result = Gson().fromJson(result.data as String, DataResponse::class.java)
                        return@withContext TMResult.Success(result)
                    }catch (e:Exception){
                        return@withContext result
                    }
                }
                is TMResult.Error ->{
                    return@withContext result
                }
            }
        }

    override suspend fun getDayCenterCategory(): TMResult =
        withContext(Dispatchers.IO) {
            when(val result= Connector.callGet(SERVER+ACTION_OP2)){
                is TMResult.Success ->{
                    try {
                        val result = Gson().fromJson(result.data as String, DataResponse::class.java)
                        return@withContext TMResult.Success(result)
                    }catch (e:Exception){
                        return@withContext result
                    }
                }
                is TMResult.Error ->{
                    return@withContext result
                }
            }
        }
}
