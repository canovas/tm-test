package com.pco.myapplication.views.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.pco.myapplication.BR
import com.pco.myapplication.R
import com.pco.myapplication.databinding.ItemListBinding
import com.pco.myapplication.networking.responses.GraphData

class GraphAdapter(private val dataModelList: List<GraphData>) :
    RecyclerView.Adapter<GraphAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: ItemListBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_list, parent, false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = dataModelList[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return dataModelList.size
    }

    inner class ViewHolder(var itemRowBinding: ItemListBinding) : RecyclerView.ViewHolder(
        itemRowBinding.root
    ) {
        fun bind(obj: Any?) {
            itemRowBinding.setVariable(BR.item, obj)
            itemRowBinding.executePendingBindings()
        }
    }
}