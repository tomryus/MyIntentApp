package com.tommy.myintentapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MoveForResultView extends AppCompatActivity implements View.OnClickListener {
    Button selectPrice;
    RadioGroup rgPrice;

    public static String EXTRA_SELECTED_VALUE = "extra_code";
    public static  int  RESULT_CODE = 100 ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_move_for_result_view);

        selectPrice = findViewById(R.id.select_price);
        selectPrice.setOnClickListener(this);

        rgPrice = findViewById(R.id.rg_price);

    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.select_price){
           if(rgPrice.getCheckedRadioButtonId() != 0){
               int value = 0;
               switch (rgPrice.getCheckedRadioButtonId()){
                   case R.id.rp200:
                       value = 200;
                       break;
                   case R.id.rp400:
                       value = 400;
                       break;
                   case R.id.rp500 :
                       value = 500;
                       break;
               }
               Intent resultIntent = new Intent();
               resultIntent.putExtra(EXTRA_SELECTED_VALUE, value);
               setResult(RESULT_CODE, resultIntent);
               finish();

           }
        }
    }
}
