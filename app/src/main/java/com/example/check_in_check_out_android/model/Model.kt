package com.example.check_in_check_out_android.model

import com.google.gson.annotations.SerializedName

data class Model(
    @SerializedName("userName")
    var userName: String?,

    @SerializedName("rollNumber")
    var rollNumber: String?,

    @SerializedName("hostel")
    var hostel: String?,

    @SerializedName("roomNumber")
    var roomNumber: String?,

    @SerializedName("phoneNumber")
    var phoneNumber: String?
)