package com.example.check_in_check_out_android.api

import com.example.check_in_check_out_android.model.RequestResponseModel
import com.example.check_in_check_out_android.model.SignInModel
import com.example.check_in_check_out_android.model.SignUpModel
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface ApiInterface {
    @Headers("Content-Type: application/json")
    @POST("/api/user/student/create")
    fun sendData1(
        @Body model1: SignUpModel
    ): Call<RequestResponseModel>


    @Headers("Content-Type: application/json")
    @POST("/api/session/create")
    fun sendData2(
        @Body model1: SignInModel
    ): Call<RequestResponseModel>


}