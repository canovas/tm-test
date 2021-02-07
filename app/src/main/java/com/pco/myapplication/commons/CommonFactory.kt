package com.pco.myapplication.commons

import android.annotation.SuppressLint
import android.content.Context


internal class CommonFactory private constructor(context: Context) {
    private val mContext = context

    companion object {
        @SuppressLint("StaticFieldLeak")
        @Volatile
        private var INSTANCE: CommonFactory? = null
        private var repository: CommonRepository? = null

        @JvmStatic
        @Synchronized
        fun getInstance(context: Context): CommonFactory {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val network = CommonDataSourceNetwork(context)
                repository = CommonRepository(network)
                val instance = CommonFactory(context.applicationContext)
                INSTANCE = instance
                return instance
            }

        }

        fun getRepository(): CommonRepository? = repository
    }

}