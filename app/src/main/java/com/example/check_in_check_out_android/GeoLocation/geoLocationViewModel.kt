package com.example.check_in_check_out_android.GeoLocation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.check_in_check_out_android.api.UserNetwork
import com.google.gson.JsonObject
import kotlinx.coroutines.launch

class geoLocationViewModel : ViewModel() {
    val response: MutableLiveData<JsonObject?> = MutableLiveData()

    fun getLoc() {
        viewModelScope.launch {
            response.value = UserNetwork.retrofit.getLocData()
        }
    }
}