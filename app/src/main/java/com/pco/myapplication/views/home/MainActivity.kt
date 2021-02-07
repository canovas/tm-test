package com.pco.myapplication.views.home

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.pco.myapplication.R
import com.pco.myapplication.databinding.ActivityMainBinding
import com.pco.myapplication.networking.responses.GraphData
import com.pco.myapplication.utils.Utils
import com.pco.myapplication.views.adapters.GraphAdapter


class MainActivity : AppCompatActivity(){
    private val viewModel: MainViewModel by viewModels()
    private val items: ArrayList<GraphData> = ArrayList()
    private lateinit var graphAdapter:GraphAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.let {
            it.lifecycleOwner = this
            it.viewModel = this.viewModel
        }

        Utils.manageLoading(this, true)

        graphAdapter = GraphAdapter(items)
        binding.adapter=graphAdapter

        prepareObservers()
    }


    private fun prepareObservers() {
        val odometerResponse = Observer { value: ArrayList<GraphData> ->
            items.addAll(value)
            graphAdapter.notifyDataSetChanged()
            Utils.manageLoading(this, false)

        }

        viewModel.dataProvided.observe(this, odometerResponse)
    }
}