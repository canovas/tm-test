package com.pco.myapplication.managers

import android.content.Context
import com.pco.myapplication.commons.CommonRepositoryNetwork
import com.pco.myapplication.conn.TMResult

class TMManagerNetwork private constructor(context: Context){
    val mContext = context

    companion object {

        @Volatile private var instance : TMManagerNetwork?   = null
        @JvmStatic  @Synchronized fun  getInstance(context: Context): TMManagerNetwork {
            if (instance == null) {
                synchronized (TMManagerNetwork) {
                    if (instance == null) {
                        instance = TMManagerNetwork(context)
                    }
                }
            }
            return instance!!
        }
    }

    suspend fun callSeniorCategory(): TMResult {
        return CommonRepositoryNetwork.getSeniorCategory()
    }
    suspend fun callDayCenterCategory(): TMResult {
        return CommonRepositoryNetwork.getDayCenterCategory()
    }

}

