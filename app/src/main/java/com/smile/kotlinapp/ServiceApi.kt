package com.smile.kotlinapp

import com.smile.kotlinapp.service.model.UserResponse
import retrofit2.Call
import retrofit2.http.GET

interface ServiceApi {

    @GET("users?q=ahmed")
    fun getUsers(): Call<UserResponse>
}