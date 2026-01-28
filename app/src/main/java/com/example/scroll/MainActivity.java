package com.example.scroll;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText a1;
    EditText q;
    Button sent;
    Switch type;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        a1 = findViewById(R.id.a1);
        q = findViewById(R.id.q);
        sent = findViewById(R.id.sent);
        type = findViewById(R.id.swich);

    }






}