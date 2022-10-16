package com.example.check_in_check_out_android.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.check_in_check_out_android.databinding.ActivitySignUpBinding

class SignUpActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignUpBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.signUpBtn.setOnClickListener {
            processFormField()
        }
    }

    private fun processFormField() {
        if (!validateUserName() || !validateRollNumber() || !validateEmail() || !validateRoomNumber() || !validatePhoneNumber()) {
            return
        } // end of check for errors

        // work to do with api
    }

    private fun validateUserName(): Boolean {
        val name: String = binding.userName.text.toString()
        return if (name.isEmpty()) {
            binding.userName.error = "UserName is Required"
            false
        } else {
            binding.userName.error = null
            true
        }
    }

    private fun validateRollNumber(): Boolean {
        val rollNumber: String = binding.rollNum.text.toString()
        return if (rollNumber.length != 5) {
            binding.rollNum.error = "Please enter a valid roll number"
            false
        } else {
            binding.rollNum.error = null
            true
        }
    }

    private fun validateRoomNumber(): Boolean {
        val roomNumber: String = binding.roomNum.text.toString()
        return if (roomNumber.length != 3) {
            binding.roomNum.error = "Please enter a valid room number"
            false
        } else {
            binding.roomNum.error = null
            true
        }
    }

    private fun validatePhoneNumber(): Boolean {
        val phoneNumber: String = binding.phoneNum.text.toString()
        return if (phoneNumber.length != 10) {
            binding.phoneNum.error = "Please enter a valid phone number"
            false
        } else {
            binding.phoneNum.error = null
            true
        }
    }

    private fun validateEmail(): Boolean {
        val email_e: String = binding.email.text.toString()

        // check if email is empty
        return if (email_e.isEmpty()) {
            binding.email.error = "Email cannot be Empty"
            false
        } else if (emailvalid(email_e)) {
            binding.email.error = "Please enter a valid email"
            false
        } else {
            binding.email.error = null
            true
        } // check if email is empty
    }
    // end of validateEmail method

    private fun emailvalid(email: String): Boolean {
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