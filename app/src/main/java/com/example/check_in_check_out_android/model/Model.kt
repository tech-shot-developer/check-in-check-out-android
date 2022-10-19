package com.example.check_in_check_out_android.model

import com.google.gson.annotations.SerializedName

data class Model(
    @SerializedName("name")
    var userName: String?,

    @SerializedName("rollNo")
    var rollNumber: String?,

    @SerializedName("phone")
    var phoneNumber: String? ,

    @SerializedName("hostelName")
    var hostel: String?,

    @SerializedName("roomNumber")
    var roomNumber: String?


)