package com.tommy.myintentapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static com.tommy.myintentapp.ObjectActivity.EXTRA_PERSON;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button btnMoveActivity;
    Button btnMoveData;
    TextView hasil;
    Button getBtnMoveObject;
    Button btncall;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btnMoveActivity = findViewById(R.id.btn_move_activity);
        btnMoveActivity.setOnClickListener(this);

        btnMoveData = findViewById(R.id.btn_move_data);
        btnMoveData.setOnClickListener(this);

        hasil = findViewById(R.id.hasil);
        hasil.setText(String.valueOf(penjumlahan(6,8)));
        //pengurangan(5,2);

        getBtnMoveObject = findViewById(R.id.btn_move_object);
        getBtnMoveObject.setOnClickListener(this);

        btncall = findViewById(R.id.btn_call);
        btncall.setOnClickListener(this);
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
                moveDataIntent.putExtra("nama", "TOMMY");
                moveDataIntent.putExtra(DataMovenActivity.EXTRA_NAME, "TOMMY");
                moveDataIntent.putExtra("extra_name", "TOMMY");
                moveDataIntent.putExtra("Umur", "15");
                startActivity(moveDataIntent);
                break;

            case R.id.btn_move_object :
                Person person = new Person();
                person.setName("Tommy");
                person.setAge(15);
                person.setCity("medan");
                person.setEmail("korekapi@gmail.com");

                Intent moveWithObject = new Intent(MainActivity.this, ObjectActivity.class);
                moveWithObject.putExtra(EXTRA_PERSON, person);
                startActivity(moveWithObject);
                break;

            case R.id.btn_call:
                String phone = "082364464977";
                Intent dialPhone  = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+phone));
                startActivity(dialPhone);
                break;
        }
    }

    public static int penjumlahan (int a, int b)
    {
        return a+b;
    }
    public void pengurangan(int a, int b){
        hasil.setText(String.valueOf(a-b));
    }
}
