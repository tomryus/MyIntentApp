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
    Button btnresult;
    TextView datareceived;

    private int REQUEST_CODE = 100 ;


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

        btnresult = findViewById(R.id.btn_result);
        btnresult.setOnClickListener(this);

        datareceived = findViewById(R.id.data_received);





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

            case R.id.btn_result:
                Intent moveForResultIntent = new Intent(MainActivity.this, MoveForResultView.class);
                startActivityForResult(moveForResultIntent, REQUEST_CODE);
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


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE) {
            if (resultCode == MoveForResultView.RESULT_CODE) {
                int selectedValue = data.getIntExtra(MoveForResultView.EXTRA_SELECTED_VALUE, 0);
                datareceived.setText(String.format("Hasil : %s", selectedValue));
            }
        }
    }
}
