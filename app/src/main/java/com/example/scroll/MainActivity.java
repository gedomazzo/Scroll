package com.example.scroll;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
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


    public void send(View view) {

        Intent shaw = new Intent(this, progression.class);

        shaw.putExtra("a1", Integer.parseInt(a1.getText().toString()));
        shaw.putExtra("q", Integer.parseInt(q.getText().toString()));
        shaw.putExtra("type", type.isChecked());

        startActivity(shaw);

    }
}