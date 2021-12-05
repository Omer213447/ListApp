package com.ax.listapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;



public class SplashScreenActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        (new Handler()).postDelayed(this::start, 2000);
    }
    private void start(){
        startActivity(new Intent(SplashScreenActivity.this, MainActivity.class));
        finish();
    }
}