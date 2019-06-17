package com.tommy.myintentapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ObjectActivity extends AppCompatActivity {
    public static final String EXTRA_PERSON = "extra_person";
    TextView objectMove;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_object);


        objectMove = findViewById(R.id.object_move);
        Person person = (Person) getIntent().getParcelableExtra(EXTRA_PERSON);
        String text = "Name : "+person.getName()+"\n, Email : "+person.getEmail()+"\n, Age : "+person.getAge()
                + ", Location : \n"+person.getCity();
        objectMove.setText(text);;


    }
}
