package com.example.check_in_check_out_android

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

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