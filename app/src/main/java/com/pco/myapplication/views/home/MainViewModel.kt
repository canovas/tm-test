package com.pco.myapplication.views.home

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.pco.myapplication.conn.TMResult
import com.pco.myapplication.managers.TMManager
import com.pco.myapplication.networking.responses.DataResponse
import com.pco.myapplication.networking.responses.GraphData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.collections.ArrayList

class MainViewModel(application: Application) : AndroidViewModel(application) {
    private var manager: TMManager? = null
    var dataProvided: MutableLiveData<ArrayList<GraphData>> = MutableLiveData()

    init{
        TMManager.inicialize(getApplication())
        manager = TMManager.getInstance()

        getGroup1()
        getGroup2()
    }

    private fun getGroup1() {
        GlobalScope.launch(Dispatchers.Main) {
            val result = withContext(Dispatchers.IO) {
                manager?.getSeniorCategory()
            }
            if (result is TMResult.Success) {
                val response = result.data as DataResponse?
                dataProvided.postValue(response?.graphList)
            }
        }
    }

    private fun getGroup2() {
        GlobalScope.launch(Dispatchers.Main) {
            val result = withContext(Dispatchers.IO) {
                manager?.getDayCenterCategory()
            }
            if (result is TMResult.Success) {
                val response = result.data as DataResponse?
                dataProvided.postValue(response?.graphList)
            }
        }
    }
}