package com.example.check_in_check_out_android

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class SignUpActivity : AppCompatActivity() {
    private lateinit var user_name: EditText
    private lateinit var roll_num:EditText
    private lateinit var phone_num:EditText
    private lateinit var room_num:EditText
    private lateinit var sign_up_btn :Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        user_name = findViewById(R.id.user_name)
        roll_num = findViewById(R.id.roll_num)
        phone_num = findViewById(R.id.phone_num)
        room_num = findViewById(R.id.room_num)
        sign_up_btn = findViewById(R.id.sign_up_btn)

        sign_up_btn.setOnClickListener{
            val Name= user_name.text.toString().trim()
            val Roll_number= roll_num.text.toString().trim()
            val Phone_no = phone_num.text.toString().trim()
            val Room_no = room_num.text.toString().trim()

            if(Name.isEmpty()){
                user_name.error = "User Name required"
                return@setOnClickListener
            }
            else if(Roll_number.length!=5){

                roll_num.error = "Enter a roll number"
                return@setOnClickListener
            }
            else if(Phone_no.length!=10){
                phone_num.error = "Enter a valid phone number"
                return@setOnClickListener
            }
            else if(Room_no.length!=3){
                room_num.error = "Enter a valid room number"
                return@setOnClickListener
            }
            else{
                Toast.makeText(this,"sign up complete",Toast.LENGTH_SHORT).show()
            }
        }

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