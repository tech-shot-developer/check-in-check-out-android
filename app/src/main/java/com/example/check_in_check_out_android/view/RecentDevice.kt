package com.example.check_in_check_out_android.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.check_in_check_out_android.databinding.ActivityRecentDeviceBinding

class RecentDevice : AppCompatActivity() {
    private lateinit var binding: ActivityRecentDeviceBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecentDeviceBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}