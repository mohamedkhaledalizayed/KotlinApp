package com.smile.kotlinapp

import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import com.smile.kotlinapp.databinding.ActivityRecyclerBinding

class RecyclerActivity : AppCompatActivity() {

    private var binding: ActivityRecyclerBinding? = null
    private lateinit var mAdapter: Adapter
    private var list: MutableList<Model> = mutableListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_recycler)

        mAdapter = Adapter(this,list)
        binding!!.recycler.layoutManager = LinearLayoutManager(this)
        binding!!.recycler.itemAnimator = DefaultItemAnimator()
        binding!!.recycler.adapter = mAdapter

        addData()
    }

    private fun addData() {


        val model = Model("mohamed","01113595439","Denshway","65")
        list.add(model)
        val model2 = Model("mohamed zayed","01113595439","egypt","15")
        list.add(model2)
        val model3 = Model("mohamed ali","01113595439","cairo","55")
        list.add(model3)
        val model4 = Model("mohamed khaled","01113595439","paris","35")
        list.add(model4)
        list.add(model)
        list.add(model)
        list.add(model)
        list.add(model)
        list.add(model)
        list.add(model)
        list.add(model)
        list.add(model)
        list.add(model)
        list.add(model)

        mAdapter.notifyDataSetChanged()
    }
}