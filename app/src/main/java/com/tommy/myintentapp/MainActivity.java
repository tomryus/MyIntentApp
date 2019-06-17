package com.tommy.myintentapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button btnMoveActivity;
    Button btnMoveData;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btnMoveActivity = findViewById(R.id.btn_move_activity);
        btnMoveActivity.setOnClickListener(this);

        btnMoveData = findViewById(R.id.btn_move_data);
        btnMoveData.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_move_activity:
                Intent moveIntent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(moveIntent);
            break;
            case R.id.btn_move_data :
                Intent moveDataIntent = new Intent(MainActivity.this, DataMovenActivity.class);
                moveDataIntent.putExtra(DataMovenActivity.EXTRA_NAME, "TOMMY");
                moveDataIntent.putExtra(DataMovenActivity.EXTRA_AGE, "15");
                startActivity(moveDataIntent);
                break;
        }
    }
}
