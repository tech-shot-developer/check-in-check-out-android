package com.example.check_in_check_out_android.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.check_in_check_out_android.R
import com.example.check_in_check_out_android.databinding.ActivityProfileBinding

class Profile : AppCompatActivity() {
    private lateinit var binding: ActivityProfileBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.profileRecentDevice.setOnClickListener{
            val intent = Intent(this, RecentDevice::class.java)
            startActivity(intent)
        }
    }
}