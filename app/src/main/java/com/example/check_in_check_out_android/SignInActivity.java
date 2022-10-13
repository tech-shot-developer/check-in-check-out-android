package com.example.check_in_check_out_android;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class SignInActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
    }

    public void backToHome(View view) {
        startActivity(new Intent(SignInActivity.this, MainActivity.class));
        finish();
    }

    public void goToSignUpAct(View view) {
        startActivity(new Intent(SignInActivity.this, SignUpActivity.class));
        finish();
    }
    // end of goToSignUpAct

}
