package com.example.lab1_androidnetworking;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.net.URL;

public class Lab1MainActivity2 extends AppCompatActivity implements View.OnClickListener {
    TextView tvMess;
    Button btnLoadImg;
    ImageView imgLoadimg;
    String url = "https://img1.pnghut.com/18/12/20/FhQUwrjcE5/area-brand-logo-orange-fpt-polytechnic.jpg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab1_main2);
        tvMess = (TextView) findViewById(R.id.mess);
        imgLoadimg = (ImageView) findViewById(R.id.imgView);
        btnLoadImg = (Button) findViewById(R.id.btnLoadImg);
        btnLoadImg.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnLoadImg) {
            loadImage();
        }
    }

private void loadImage(){
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                final Bitmap bitmap = loadimgFormNetwork(url);
                imgLoadimg.post(new Runnable() {
                    @Override
                    public void run() {
                        tvMess.setText("loading thanh cong");
                        imgLoadimg.setImageBitmap(bitmap);
                    }
                });
            }
        });
        thread.start();
}



        public Bitmap loadimgFormNetwork (String strURL) {
            URL url;
            Bitmap bmp = null;
            try {
                url = new URL(strURL);
                bmp = BitmapFactory.decodeStream(url.openConnection().getInputStream());

            } catch (Exception e) {
                Log.i("ERR", "->" + e.toString());
            }
            return bmp;

    }

}