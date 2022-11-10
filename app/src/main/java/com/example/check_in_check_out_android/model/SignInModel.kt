package com.example.check_in_check_out_android.model

import com.google.gson.annotations.SerializedName

data class SignInModel(

    @SerializedName("email")
    var email: String?,

    @SerializedName("password")
    var password: String?,

//    @SerializedName("token-access")
//    var token: String?,

)