package com.smile.kotlinapp.service

import android.app.Application
import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.smile.kotlinapp.BuildConfig
import com.smile.kotlinapp.ServiceApi
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

import java.io.File
import java.util.concurrent.TimeUnit


class TextConvert private constructor(private val context: Application) {
    private var cache: Cache? = null
    private var gson: Gson? = null
    private var okHttpClient: OkHttpClient? = null
    private var retrofit: Retrofit? = null
    var service: ServiceApi? = null
        private set
    private val BASE_URL = "https://api.github.com/search/"

    init {
        provideCache()
        provideGson()
        provideOkhttpClient()
        provideRetrofit()
        provideService()
    }

    private fun provideCache() {
        val cachSize = (10 * 1024 * 1024).toLong()
        try {
            val myDir = File(context.cacheDir, "response")
            myDir.mkdir()
            cache = Cache(myDir, cachSize)
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }

    private fun provideGson() {
        val gsonBuilder = GsonBuilder()
        gsonBuilder.setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
        gson = gsonBuilder.setLenient().create()
    }

    private fun provideOkhttpClient() {
        val interceptor = HttpLoggingInterceptor()
        if (BuildConfig.DEBUG) {
            interceptor.level = HttpLoggingInterceptor.Level.BODY
        }
        okHttpClient = OkHttpClient.Builder()
            .writeTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .addInterceptor(interceptor)
            .build()
    }

    private fun provideRetrofit() {
        retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create(gson!!))
            .baseUrl(BASE_URL)
            .client(okHttpClient!!)
            .build()
    }

    private fun provideService() {
        service = retrofit!!.create(ServiceApi::class.java)
    }

    companion object {
        var instance: TextConvert? = null
            private set


        fun intialize(context: Application) {
            instance = TextConvert(context)
        }
    }

}
