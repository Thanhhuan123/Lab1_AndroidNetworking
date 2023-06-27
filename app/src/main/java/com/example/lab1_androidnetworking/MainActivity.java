package com.example.lab1_androidnetworking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btnBai1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void Bai1(View view) {
        Intent intent = new Intent(MainActivity.this,Lab1MainActivity2.class);
        startActivity(intent);
    }
    public void Bai2(View view) {
        Intent intent = new Intent(MainActivity.this,Lab21MainActivity2.class);
        startActivity(intent);
    }
}