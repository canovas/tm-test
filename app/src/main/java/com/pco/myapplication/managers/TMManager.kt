package com.pco.myapplication.managers

import android.content.Context
import com.pco.myapplication.commons.CommonFactory
import com.pco.myapplication.conn.TMResult
import com.pco.myapplication.utils.generateResultError

class TMManager private constructor(context: Context){

    companion object {
        @Volatile
        private var INSTANCE: TMManager? = null
        @JvmStatic
        @Synchronized
        fun inicialize(context: Context): TMManager {

            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = TMManager(context.applicationContext)
                CommonFactory.getInstance(context)

                INSTANCE = instance
                return instance
            }
        }
        fun getInstance(): TMManager?{
            return INSTANCE
        }
    }

    suspend fun getSeniorCategory(): TMResult {
        return CommonFactory.getRepository()?.getSeniorCategory() ?: generateResultError()
    }


    suspend fun getDayCenterCategory(): TMResult {
        return CommonFactory.getRepository()?.getDayCenterCategory() ?: generateResultError()
    }

}