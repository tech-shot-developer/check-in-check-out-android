package com.example.check_in_check_out_android.api

import com.example.check_in_check_out_android.util.constant.Companion.BASE_URL_GET
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object UserNetwork {
    val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL_GET)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiInterface::class.java)
    }
}