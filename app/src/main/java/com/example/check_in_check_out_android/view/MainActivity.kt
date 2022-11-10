package com.example.check_in_check_out_android.view


import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.check_in_check_out_android.databinding.ActivityMainBinding
import com.example.check_in_check_out_android.util.constant.Companion.PREF_UNIQUE_ID
import com.example.check_in_check_out_android.util.constant.Companion.machineID
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val context = this@MainActivity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        // start of machine id
        if (machineID == null) {
            val sharedPrefs: SharedPreferences = context.getSharedPreferences(
                PREF_UNIQUE_ID, Context.MODE_PRIVATE
            )
            machineID = sharedPrefs.getString(PREF_UNIQUE_ID, null)
            if (machineID == null) {
                machineID = UUID.randomUUID().toString()
                val editor: SharedPreferences.Editor = sharedPrefs.edit()
                editor.putString(PREF_UNIQUE_ID, machineID)
                editor.apply()
            }
            startActivity(Intent(this@MainActivity, SignUpActivity::class.java))
        } else {
            val signUp = SignUpActivity()
            if (signUp.isOkFromSignUp()) {
                startActivity(Intent(this@MainActivity, SignInActivity::class.java))
            } else {
                startActivity(Intent(this@MainActivity, SignUpActivity::class.java))
            }
        }
        // end of machine id


    }
}