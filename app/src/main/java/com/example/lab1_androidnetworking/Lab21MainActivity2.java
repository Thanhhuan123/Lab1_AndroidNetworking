package com.example.lab1_androidnetworking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class Lab21MainActivity2 extends AppCompatActivity {
    public static int TIME_OUT = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab21_main2);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(Lab21MainActivity2.this,Lab2MainActivity2.class);
                startActivity(intent);
                finish();
            }
        },TIME_OUT);
    }
}