package com.tommy.myintentapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DataMovenActivity extends AppCompatActivity {
    public static final String EXTRA_NAME = "extra_name";
    public static final String EXTRA_AGE = "extra_age" ;
    public  static  final  int a=5;
    public  static  final  int b=11;

    TextView tVreceive;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_moven);

        tVreceive = findViewById(R.id.data_received);

        String name = getIntent().getStringExtra("Nama");
        String age = getIntent().getStringExtra("Umur");

        String bio = "nama : " + name + "\n " + " Umur : " + age  ;
        //tVreceive.setText(bio);

        int jumlah = Integer.parseInt(age) + 15 ;

        tVreceive.setText(String.valueOf(MainActivity.penjumlahan(5,8)));

    }
}
