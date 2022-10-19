package com.example.check_in_check_out_android.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.check_in_check_out_android.R

class SignInActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)



    }

    fun backToHome(view: View?) {
        startActivity(Intent(this@SignInActivity, MainActivity::class.java))
        finish()
    }// end of backToHome method

    fun goToSignUpAct(view: View?) {
        startActivity(Intent(this@SignInActivity, SignUpActivity::class.java))
        finish()
    } // end of goToSignUpAct
}