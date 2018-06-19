package com.example.ferna.mysc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.content.Intent;

public class SplashScreenActivity extends AppCompatActivity {
    //private static int SPLASH_TIME_OUT = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        Handler handle = new Handler();
        handle.postDelayed(new Runnable() {
            @Override
            public void run() {
                mostrarLogin();
            }
        }, 3000);
    }

    private void mostrarLogin() {
        Intent intent = new Intent(SplashScreenActivity.this,
                MainActivity.class);
        startActivity(intent);
        finish();
    }

}
