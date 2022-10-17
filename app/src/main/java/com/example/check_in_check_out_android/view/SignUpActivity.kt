package com.example.check_in_check_out_android.view

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.check_in_check_out_android.api.RetrofitHelper
import com.example.check_in_check_out_android.databinding.ActivitySignUpBinding
import com.example.check_in_check_out_android.model.Model
import org.json.JSONException
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

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
        if (!validateUserName() || !validateRollNumber() || !validateRoomNumber() || !validatePhoneNumber()) {
            return
        }

        // progress bar visible
        binding.pb.visibility = View.VISIBLE

        try {
            val jsonObject = JSONObject()
            jsonObject.put("name", binding.userName.text.toString())
            jsonObject.put("rollNo", binding.rollNum.text.toString())
            jsonObject.put("phone", binding.phoneNum.text.toString())
            jsonObject.put("hostelName", binding.hostelNameSpinner.selectedItem.toString())
            jsonObject.put("roomNumber", binding.roomNum.text.toString().toInt())

            val retrofit = RetrofitHelper()
            retrofit.buildService().sendData(jsonObject)
                .enqueue(object : Callback<Model> {
                    override fun onResponse(call: Call<Model>, response: Response<Model>) {

                        binding.userName.text = null
                        binding.rollNum.text = null
                        binding.roomNum.text = null
                        binding.phoneNum.text = null

                        // progress bar invisible
                        binding.pb.visibility = View.INVISIBLE

                        Toast.makeText(this@SignUpActivity, "Data added to API", Toast.LENGTH_SHORT)
                            .show()
                        Log.d("data", response.toString())
                    }

                    override fun onFailure(call: Call<Model>, t: Throwable) {
                        Log.d("Error", t.message.toString())
                    }
                })
        } catch (e: JSONException) {
            e.printStackTrace()
        }
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

    fun backToHome(view: View?) {
        startActivity(Intent(this@SignUpActivity, MainActivity::class.java))
        finish()
    }// end of backToHome method

    fun goToSignInAct(view: View?) {
        startActivity(Intent(this@SignUpActivity, SignInActivity::class.java))
        finish()
    } // end of goToSignInAct method
}