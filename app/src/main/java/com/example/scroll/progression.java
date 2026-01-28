package com.example.scroll;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class progression extends AppCompatActivity {

    Integer[] list = new Integer[20];
    ListView lister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progression);

        lister = findViewById(R.id.list);

        Intent intent = getIntent();
        int a1 = intent.getIntExtra("a1", 1); // Default to 1 to avoid multiplying by 0
        int q = intent.getIntExtra("q", 1);   // Default to 1 to avoid multiplying by 0 or 1
        boolean type = intent.getBooleanExtra("type", true);

        if (type) { // Geometric
            for (int n = 0; n < 20; n++) {
                // Math.pow returns a double, so we must cast it to an int
                list[n] = (int) (a1 * Math.pow(q, n));
            }
        } else { // Arithmetic
            int current = a1;
            for (int n = 0; n < 20; n++) {
                list[n] = current;
                current += q;
            }
        }

        ArrayAdapter<Integer> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, list);
        lister.setAdapter(adapter);
    }
}
