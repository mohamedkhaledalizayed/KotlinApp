package com.smile.kotlinapp.service.activity

import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import com.smile.kotlinapp.R
import com.smile.kotlinapp.databinding.ActivityUsersBinding
import com.smile.kotlinapp.service.RetrofitModule
import com.smile.kotlinapp.service.adapter.UserAdapter
import com.smile.kotlinapp.service.model.ItemsItem
import com.smile.kotlinapp.service.model.UserResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UsersActivity : AppCompatActivity() {

    var service = RetrofitModule.getInstance().getService()
    private var binding: ActivityUsersBinding? = null
    private lateinit var mAdapter: UserAdapter
    private val numbers: MutableList<ItemsItem> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_users)
        binding!!.recycler.layoutManager = LinearLayoutManager(this)
        binding!!.recycler.itemAnimator = DefaultItemAnimator()
        getUser()
    }

    private fun getUser() {
        service.getUsers().enqueue(object : Callback<UserResponse> {
            override fun onResponse(call: Call<UserResponse>, response: Response<UserResponse>) {
                mAdapter = UserAdapter(response.body()!!.items as List<ItemsItem>)
                binding!!.recycler.adapter = mAdapter

                for (i in 0 until response.body()!!.items!!.size){
                    println(response.body()!!.items!![i]!!.avatarUrl)
                    numbers.add(response.body()!!.items!![0]!!)
                }
            }

            override fun onFailure(call: Call<UserResponse>, t: Throwable?) {
                Log.e("Error", t.toString())
            }
        })
    }
}