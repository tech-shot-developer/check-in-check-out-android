package com.example.check_in_check_out_android.view

import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.check_in_check_out_android.databinding.ActivityDashboardBinding
import com.google.zxing.BarcodeFormat
import com.journeyapps.barcodescanner.BarcodeEncoder


class Dashboard : AppCompatActivity() {
    private lateinit var binding: ActivityDashboardBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDashboardBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.profilebutton.setOnClickListener {
            val intent = Intent(this, Profile::class.java)
            startActivity(intent)
        }
        binding.generateBtn.setOnClickListener{
            val content = "Hello"
            var bitmap: Bitmap? = null
            val barcodeEncoder = BarcodeEncoder()
                bitmap = barcodeEncoder.encodeBitmap(content,
                    BarcodeFormat.QR_CODE, 300, 300);

            binding.ivQR.setImageBitmap(bitmap)
        }

    }
}