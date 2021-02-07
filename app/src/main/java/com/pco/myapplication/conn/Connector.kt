package com.pco.myapplication.conn

import android.net.Uri
import android.util.Log
import com.pco.myapplication.utils.generateError
import com.pco.myapplication.utils.generateTypeError


import java.net.HttpURLConnection
import java.net.URL

import javax.net.ssl.HttpsURLConnection


object Connector {
        private const val TAG = "TAG.ds.Connector"

        fun callGet(url: String, header : HashMap<String,String>? = null, parameters: HashMap<String,Any?>? = null, relativeUrl: List<Any>? = null): TMResult {

            try {
                val route = StringBuilder()
                route.append(url)

                relativeUrl?.let {
                    for (aux in it) {
                        route.append(aux.toString()).append("/")
                    }
                }

                val builtUri = Uri.parse(route.toString()).buildUpon()
                parameters?.map {
                        builtUri.appendQueryParameter(it.key, it.value.toString())
                    }

                builtUri.build()
                val url = URL(builtUri.toString())
                val conn = url.openConnection() as HttpURLConnection
                conn.readTimeout = 90000
                conn.connectTimeout = 90000
                conn.requestMethod = "GET"
                conn.setRequestProperty("Content-Type", "application/json")
                if (!header.isNullOrEmpty()) {
                    header.map {
                        conn.addRequestProperty(it.key, it.value)
                    }
                }
                conn.doInput = true

                conn.connect()

                /*Log.i(TAG, "LOG:::--------")
                Log.i(TAG, "LOG:::VALUES:$url")
                Log.i(TAG, "LOG:::--------")*/

                val responseCode = conn.responseCode
                if (responseCode == HttpsURLConnection.HTTP_OK) {
                    return if (conn.inputStream != null) {
                        val text = conn.inputStream.use { it.reader().use { reader -> reader.readText() } }
                        /*Log.i(TAG, "LOG:::--------")
                        Log.i(TAG, "LOG:::RESPONSE:$text")
                        Log.i(TAG, "LOG:::--------")*/
                        conn.inputStream.close()
                        return TMResult.Success(text)
                    } else {
                        return TMResult.Error(generateError(responseCode, message = conn.responseMessage))
                    }
                }else{
                    Log.i(TAG,"Result empty")
                    return TMResult.Error(generateError(responseCode, message = conn.responseMessage))
                }
            } catch (e: Exception) {
                /*Log.i(TAG, "LOG:::--------")
                Log.i(TAG, "LOG:::RESPONSE:$e")
                Log.i(TAG, "LOG:::--------")*/
                return TMResult.Error(generateError(generateTypeError(e.message), message = e.localizedMessage))
            }
        }
    }