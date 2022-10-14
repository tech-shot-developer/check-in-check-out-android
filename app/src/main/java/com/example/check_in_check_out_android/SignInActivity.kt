package com.example.check_in_check_out_android

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class SignInActivity : AppCompatActivity() {
    private lateinit var email:EditText
    private lateinit var password:EditText
    private lateinit var sign_in_btn:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)
        email = findViewById(R.id.email)
        password = findViewById(R.id.password)
        sign_in_btn = findViewById((R.id.sign_in_btn))

        sign_in_btn.setOnClickListener{
            val Email = email.text.toString().trim()
            val Password = password.text.toString().trim()

            if(Email.length<5){

            }
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
}