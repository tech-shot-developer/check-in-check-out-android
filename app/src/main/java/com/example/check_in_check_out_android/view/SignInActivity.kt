package com.example.check_in_check_out_android.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.check_in_check_out_android.R
import com.example.check_in_check_out_android.databinding.ActivitySignInBinding
import okhttp3.Call
import okhttp3.Callback
import okhttp3.OkHttpClient
import okhttp3.Response
import java.io.IOException

class SignInActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignInBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignInBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.signInBtn.setOnClickListener{
            //authenticate user here

            goToDashboard()
        }
    }

    fun backToHome(view: View?) {
        startActivity(Intent(this@SignInActivity, MainActivity::class.java))
        finish()
    }// end of backToHome method

    fun goToSignUpAct(view: View?) {
        startActivity(Intent(this@SignInActivity, SignUpActivity::class.java))
        finish()
    } // end of goToSignUpAct

    fun goToDashboard() {

        //fetching geolocation
        val request = okhttp3.Request.Builder().url("https://ipwho.is/").build()

        val client = OkHttpClient()
        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                println("Failed")
            }

            override fun onResponse(call: Call, response: Response) {
                val body = response?.body()?.string()
                println(body)
            }
        })


        startActivity(Intent(this@SignInActivity, Dashboard::class.java))
        finish()
    } // end of goToDashboard
}