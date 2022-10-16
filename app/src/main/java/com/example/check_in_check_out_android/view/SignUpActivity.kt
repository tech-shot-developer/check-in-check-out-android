package com.example.check_in_check_out_android.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.check_in_check_out_android.databinding.ActivitySignUpBinding

class SignUpActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignUpBinding
    private lateinit var user_name: EditText
    private lateinit var roll_num: EditText
    private lateinit var phone_num: EditText
    private lateinit var room_num: EditText
    private lateinit var email: EditText
    private lateinit var sign_up_btn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)
        user_name = binding.userName
        roll_num = binding.rollNum
        phone_num = binding.phoneNum
        room_num = binding.roomNum
        email = binding.email
        sign_up_btn = binding.signUpBtn

        sign_up_btn.setOnClickListener {
            val Name = user_name.text.toString().trim()
            val Roll_number = roll_num.text.toString().trim()
            val Phone_no = phone_num.text.toString().trim()
            val Room_no = room_num.text.toString().trim()
            val Email = email.text.toString().trim()

            if (Name.isEmpty()) {
                user_name.error = "User Name required"
                return@setOnClickListener
            } else if (emailvalid(Email)) {
                email.error = "Invalid email"
            } else if (Roll_number.length != 5) {

                roll_num.error = "Enter a roll number"
                return@setOnClickListener
            } else if (Room_no.length != 3) {
                room_num.error = "Enter a valid room number"
                return@setOnClickListener
            } else if (Phone_no.length != 10) {
                phone_num.error = "Enter a valid phone number"
                return@setOnClickListener
            } else {
                Toast.makeText(this, "sign up complete", Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun emailvalid(email: String): Boolean {
        return !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    fun backToHome(view: View?) {
        startActivity(Intent(this@SignUpActivity, MainActivity::class.java))
        finish()
    }// end of backToHome method

    fun goToSignInAct(view: View?) {
        startActivity(Intent(this@SignUpActivity, SignInActivity::class.java))
        finish()
    } // end of goToSignInAct method
}