package com.smile.kotlinapp

import android.content.Context
import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.smile.kotlinapp.databinding.RecyclerItemLayoutBinding

class Adapter(private val context: Context, private val list: List<Model>) : RecyclerView.Adapter<Adapter.MyViewHolder>() {

    private var layoutInflater: LayoutInflater? = null
    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): MyViewHolder {
        if (layoutInflater == null) {
            layoutInflater = LayoutInflater.from(parent.context)
        }


        var binding: RecyclerItemLayoutBinding =
            DataBindingUtil.inflate(layoutInflater!!, R.layout.recycler_item_layout, parent, false)

        return Adapter.MyViewHolder(binding)
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.binding.model = list[position]
        holder.binding.item.setOnClickListener {
            context.showToast("$position")
        }
    }

    class MyViewHolder(var binding: RecyclerItemLayoutBinding) : RecyclerView.ViewHolder(binding.root)
}