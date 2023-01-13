package com.devdroid.sharedprefrence;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

import com.google.android.material.navigation.NavigationView;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                SharedPreferences sharedPreferences = getSharedPreferences("login",MODE_PRIVATE);
                Boolean check = sharedPreferences.getBoolean("flag",false);

                Intent iNext;
                if (check)
                {
                    // for true (if user logged in)
                    iNext = new Intent(getApplicationContext(),HomeActivity.class);
                }
                else
                {
                    // for false if user not logged in or if user logged out
                    iNext = new Intent(getApplicationContext(),MainActivity.class);
                }
                startActivity(iNext);
            }
        },2000);
    }
}