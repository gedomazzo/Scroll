package com.example.scroll;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;

import androidx.annotation.NonNull;
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


        if (!a1.getText().toString().equals(""))  shaw.putExtra("a1", Integer.parseInt(a1.getText().toString()));

        if (!q.getText().toString().equals("")) shaw.putExtra("q", Integer.parseInt(q.getText().toString()));
        shaw.putExtra("type", type.isChecked());

        startActivity(shaw);

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        String temp = item.getTitle().toString();
        if (temp.equals("Credits")) {
            Intent kuku = new Intent(this, MyActivityName.class);
            startActivity(kuku);
        }

        return super.onOptionsItemSelected(item);
    }
}