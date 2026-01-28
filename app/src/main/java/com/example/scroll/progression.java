package com.example.scroll;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class progression extends AppCompatActivity implements AdapterView.OnItemClickListener, View.OnCreateContextMenuListener {

    Integer[] list = new Integer[20];
    ListView lister;

    TextView ans;

    boolean EHFM; // end help for me

    int a1;
    int q;
    boolean type;

    int selectedIndex = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progression);

        lister = findViewById(R.id.list);
        ans = findViewById(R.id.ans);

        Intent intent = getIntent();
        a1 = intent.getIntExtra("a1", 1);
        q = intent.getIntExtra("q", 2);
        type = intent.getBooleanExtra("type", true);

        if (type) {
            for (int n = 0; n < 20; n++) {
                list[n] = (int) (a1 * Math.pow(q, n));
            }
        } else {
            for (int n = 0; n < 20; n++) {
                list[n] = a1 + n * q;
            }
        }

        ArrayAdapter<Integer> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, list);
        lister.setAdapter(adapter);
        lister.setOnItemClickListener(this);
        lister.setOnCreateContextMenuListener(this);



    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View view, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, view, menuInfo);

        AdapterView.AdapterContextMenuInfo info =
                (AdapterView.AdapterContextMenuInfo) menuInfo;

        selectedIndex = info.position;

        menu.setHeaderTitle("what you want to know");
        menu.add("sum");
        menu.add("index");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        String oper = item.getTitle().toString();
        int result = 0;
        int n = selectedIndex + 1;

        if (oper.equals("sum")) {
            if (type) {
                // geometric sum
                result = (int) (a1 * (Math.pow(q, n) - 1) / (q - 1));
            } else {
                // arithmetic sum
                result = n * (2 * a1 + (n - 1) * q) / 2;
            }
            ans.setText("Sum = " + result);

        } else if (oper.equals("index")) {
            ans.setText("Index = " + n);
        }

        return true;
    }



    @Override
    public void onItemClick(AdapterView<?> parent, View view, int n, long id) {}


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        String temp = item.getTitle().toString();
        if (temp.equals("Credits")) {
            Intent shaw = new Intent(this, MyActivityName.class);
            startActivity(shaw);
        }

        return super.onOptionsItemSelected(item);
    }

}
