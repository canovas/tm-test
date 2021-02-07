package com.pco.myapplication.commons

import android.content.Context
import com.pco.myapplication.conn.TMResult
import com.pco.myapplication.managers.TMManagerNetwork

internal class CommonDataSourceNetwork(context: Context): CommonDatasourceNetworkI {
    private val mDaoNetwork = TMManagerNetwork.getInstance(context)

    override suspend fun getSeniorCategory(): TMResult =
        mDaoNetwork.callSeniorCategory()


    override suspend fun getDayCenterCategory(): TMResult =
        mDaoNetwork.callDayCenterCategory()

}

