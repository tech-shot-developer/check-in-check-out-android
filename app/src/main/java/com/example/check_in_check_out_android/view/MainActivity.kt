package com.example.check_in_check_out_android.view


import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.check_in_check_out_android.GeoLocation.geoLocationViewModel
import com.example.check_in_check_out_android.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        // start of geolocation of device
        val viewModel = ViewModelProvider(this)[geoLocationViewModel::class.java]
        // single request
        viewModel.getLoc()
        viewModel.response.observe(this, Observer {
            Log.d("MainActivity", it.toString())
        })
        // end of geolocation of device



        binding.signup.setOnClickListener {
            val intent = Intent(this@MainActivity, SignUpActivity::class.java)
            startActivity(intent)
        }

        binding.signin.setOnClickListener {
            startActivity(Intent(this@MainActivity, SignInActivity::class.java))
        }
    }
}