package com.example.lab1_androidnetworking;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Lab2MainActivity2 extends AppCompatActivity implements View.OnClickListener {


    private ImageView imageView;
    private Button btnLoad;
    String url = "https://img1.pnghut.com/18/12/20/FhQUwrjcE5/area-brand-logo-orange-fpt-polytechnic.jpg";

    private Bitmap bitmap = null;
    private TextView tvMess;
    private ProgressDialog progressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab2_main2);

        imageView = findViewById(R.id.image2);
        btnLoad = findViewById(R.id.btnLoadImg2);
        tvMess = findViewById(R.id.tvMessBai2);
        btnLoad.setOnClickListener(this);

    }


    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {
        progressDialog = progressDialog.show(Lab2MainActivity2.this,"Dang dowload","dang dowloaddd");
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                bitmap = dwBitmap(url);
                Message msg = messHandler.obtainMessage();
                Bundle bundle = new Bundle();
                String thMessage = "da dowload xong";
                bundle.putString("message",thMessage);
                msg.setData(bundle);
                messHandler.sendMessage(msg);

            }
        };
    }
    private Handler messHandler = new Handler(){
        public void handlerMessenge(Message msg){
            super.handleMessage(msg);
            Bundle bundle = msg.getData();
            String message = bundle.getString("message");
            tvMess.setText(message);
            imageView.setImageBitmap(bitmap);
            progressDialog.dismiss();
        }
    };

    private Bitmap dwBitmap(String link){
        try {
            URL url = new URL(link);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.connect();
            InputStream inputStream = connection.getInputStream();
            Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
            return bitmap;
        }catch (MalformedURLException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}