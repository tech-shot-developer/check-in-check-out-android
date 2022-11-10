package com.example.check_in_check_out_android.view

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.View

import android.widget.Button
import android.widget.EditText

import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.check_in_check_out_android.api.RetrofitClient
import com.example.check_in_check_out_android.databinding.ActivitySignUpBinding
import com.example.check_in_check_out_android.model.RequestResponseModel
import com.example.check_in_check_out_android.model.SignUpModel
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

open class SignUpActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignUpBinding

    var clicked: Boolean = false

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
        sign_up_btn = binding.signUpBtn

        binding.signUpBtn.setOnClickListener {
            clicked = true
            processFormField()
        }
    }

    private fun processFormField() {
        if (!validateUserName() || !validateRollNumber() || !validateRoomNumber() || !validatePhoneNumber()) {
            return
        }

        // progress bar visible
        binding.pb.visibility = View.VISIBLE

        try {

            val signUpModel = SignUpModel(
                binding.userName.text.toString(),
                binding.rollNum.text.toString(),
                binding.phoneNum.text.toString(),
                binding.hostelNameSpinner.selectedItem.toString(),
                binding.roomNum.text.toString()
            )

            val retrofit = RetrofitClient()
            retrofit.buildService().sendData1(signUpModel)
                .enqueue(object : Callback<RequestResponseModel> {
                    override fun onResponse(
                        call: Call<RequestResponseModel>,
                        response: Response<RequestResponseModel>
                    ) {

                        binding.userName.text = null
                        binding.rollNum.text = null
                        binding.roomNum.text = null
                        binding.phoneNum.text = null

                        // progress bar invisible
                        binding.pb.visibility = View.INVISIBLE

                        val myResponse = response.body()
                        val myCode = response.code()
                        val jsonObjectError = JSONObject(response.errorBody()!!.string())
                        if (myCode == 200) {
                            Toast.makeText(
                                this@SignUpActivity,
                                myResponse?.msg.toString(),
                                Toast.LENGTH_SHORT
                            ).show()
                            Handler().postDelayed({
                                Toast.makeText(
                                    this@SignUpActivity, "Sign In yourself", Toast.LENGTH_LONG
                                ).show()
                            }, 1000)
                        } else if (myCode == 400) {
                            Toast.makeText(
                                this@SignUpActivity,
                                jsonObjectError.getString("msg"),
                                Toast.LENGTH_LONG
                            ).show()
                        }

                    }

                    override fun onFailure(call: Call<RequestResponseModel>, t: Throwable) {
                        Toast.makeText(
                            this@SignUpActivity,
                            t.message.toString(),
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                })
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    open fun getInstance(): Context {
        return this@SignUpActivity
    }

    open fun isOkFromSignUp(): Boolean {
        return clicked
    }

    private fun validateUserName(): Boolean {
        val name: String = binding.userName.text.toString()
        return if (name.isEmpty()) {
            binding.userName.requestFocus()
            binding.userName.error = "Username is Required"
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


//    private fun validateEmail(): Boolean {
//        val email_e: String = binding.email.text.toString()
//
//        // check if email is empty
//        return if (email_e.isEmpty()) {
//            binding.email.error = "Email cannot be Empty"
//            false
//        } else if (emailvalid(email_e)) {
//            binding.email.error = "Please enter a valid email"
//            false
//        } else {
//            binding.email.error = null
//            true
//        } // check if email is empty
//    }
//    // end of validateEmail method

//    private fun emailvalid(email: String): Boolean {
//        return !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
//    }

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