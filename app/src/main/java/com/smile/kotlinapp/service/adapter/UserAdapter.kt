package com.smile.kotlinapp.service.adapter

import android.content.Context
import android.databinding.DataBindingUtil
import android.support.v7.view.menu.ActionMenuItemView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.smile.kotlinapp.R
import com.smile.kotlinapp.databinding.UserItemLayoutBinding
import com.smile.kotlinapp.service.model.ItemsItem

class UserAdapter(var usersList: List<ItemsItem>): RecyclerView.Adapter<UserAdapter.MyViewHolder>() {
    var layoutInflater: LayoutInflater? = null
    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): MyViewHolder {
        if (layoutInflater == null){
            layoutInflater = LayoutInflater.from(parent.context)
        }

        var binding: UserItemLayoutBinding =
            DataBindingUtil.inflate(layoutInflater!!, R.layout.user_item_layout,parent,false)

        return UserAdapter.MyViewHolder(binding)

    }

    override fun getItemCount() = usersList.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.binding.setItem(usersList[position])
    }

    class MyViewHolder(var binding: UserItemLayoutBinding): RecyclerView.ViewHolder(binding.root)
}