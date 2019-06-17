package com.tommy.myintentapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DataMovenActivity extends AppCompatActivity {
    public static final String EXTRA_NAME = "extra_name";
    public static final String EXTRA_AGE = "extra_age";
    TextView tVreceive;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_moven);

        tVreceive = findViewById(R.id.data_received);

        String name = getIntent().getStringExtra(EXTRA_NAME);
        int age = getIntent().getIntExtra(EXTRA_AGE, 0);

        String bio = "nama : " + name + "\n " + " Umur : " + age  ;
        tVreceive.setText(bio);


    }
}
