package com.example.check_in_check_out_android.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.check_in_check_out_android.api.RetrofitClient2
import com.example.check_in_check_out_android.databinding.ActivitySignInBinding
import com.example.check_in_check_out_android.model.RequestResponseModel
import com.example.check_in_check_out_android.model.SignInModel
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignInActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignInBinding
    private lateinit var pass: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignInBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.signInBtn.setOnClickListener {
            processFormField()
        }

    }

    private fun processFormField() {
        if (!validateEmail()) {
            return
        }

        // progress bar visible
        binding.pb.visibility = View.VISIBLE

//        // showing toast after 2 sec
//        Handler().postDelayed({
//            Toast.makeText(
//                this@SignInActivity, "Successfully Logged-In", Toast.LENGTH_LONG
//            ).show()
//        }, 2000)
//        // showing toast after 2 sec

        try {

            val signInModel = SignInModel(
                binding.email.text.toString(),
                binding.password.text.toString(),
            )

            val retrofit = RetrofitClient2()
            retrofit.buildService().sendData2(signInModel)
                .enqueue(object : Callback<RequestResponseModel> {
                    override fun onResponse(
                        call: Call<RequestResponseModel>,
                        response: Response<RequestResponseModel>
                    ) {

                        binding.email.text = null
                        binding.password.text = null

                        // progress bar invisible
                        binding.pb.visibility = View.INVISIBLE

                        val myResponse = response.body()
                        val myCode = response.code()
                        val jsonObjectError = JSONObject(response.errorBody()!!.string())
                        if (myCode == 200) {
                            Toast.makeText(
                                this@SignInActivity,
                                myResponse?.msg.toString(),
                                Toast.LENGTH_SHORT
                            ).show()
                        } else if (myCode == 400) {
                            Toast.makeText(
                                this@SignInActivity,
                                jsonObjectError.getString("msg"),
                                Toast.LENGTH_LONG
                            ).show()
                        }

                    }

                    override fun onFailure(call: Call<RequestResponseModel>, t: Throwable) {
                        Toast.makeText(
                            this@SignInActivity, t.message.toString(), Toast.LENGTH_SHORT
                        ).show()
                    }
                })
        } catch (e: Exception) {
            e.printStackTrace()
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

    private fun emailvalid(email: String): Boolean {
        return !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }
    // end of validateEmail method

    fun backToHome(view: View?) {
        startActivity(Intent(this@SignInActivity, MainActivity::class.java))
        finish()
    }// end of backToHome method

    fun goToSignUpAct(view: View?) {
        startActivity(Intent(this@SignInActivity, SignUpActivity::class.java))
        finish()
    } // end of goToSignUpAct
}