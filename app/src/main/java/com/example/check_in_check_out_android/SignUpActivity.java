package com.example.check_in_check_out_android;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class SignUpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
    }

    public void backToHome(View view) {
        startActivity(new Intent(SignUpActivity.this, MainActivity.class));
        finish();
    }
    // end of backToHome method

    public void goToSignInAct(View view) {
        startActivity(new Intent(SignUpActivity.this, SignInActivity.class));
        finish();
    }
    // end of goToSignInAct method

}
