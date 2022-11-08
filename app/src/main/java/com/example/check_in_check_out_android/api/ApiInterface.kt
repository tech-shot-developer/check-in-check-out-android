package com.example.check_in_check_out_android.api

import com.example.check_in_check_out_android.model.Model
import com.example.check_in_check_out_android.model.RequestResponseModel
import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST

interface ApiInterface {
    @Headers("Content-Type: application/json")
    @POST("/api/user/student/create")
    fun sendData(
        @Body model: Model
    ): Call<RequestResponseModel>

    @GET("/")
    suspend fun getLocData(): JsonObject?
}