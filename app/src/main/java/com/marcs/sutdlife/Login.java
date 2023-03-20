package com.marcs.sutdlife;

import static com.marcs.mytestfirebaseapplication.R.id.registration;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

import com.marcs.mytestfirebaseapplication.R;

public class Login extends AppCompatActivity {
    androidx.appcompat.widget.AppCompatButton callSignUp;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // The line below hides the status bar from the screen
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.login);

        callSignUp = findViewById(registration);

        callSignUp.setOnClickListener(view) {
            Intent intent = new Intent(Login.this, SignUp.class);
            startActivities(new Intent[]{intent});
        }
    }
}
