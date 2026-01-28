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

/**
 * @author        benjamin rogachevsky
 * @version       1.0
 * @since         1/7/26
 * This activity displays a numerical progression and allows users to see details about it.
 */
public class progression extends AppCompatActivity implements AdapterView.OnItemClickListener, View.OnCreateContextMenuListener {

    /** The array holding the generated progression numbers. */
    Integer[] list = new Integer[20];
    /** The ListView UI element that displays the progression. */
    ListView lister;

    /** The TextView UI element to show calculation results. */
    TextView ans;

    /** The first term of the progression. */
    int a1;
    /** The common difference or ratio of the progression. */
    int q;
    /** The type of progression: true for geometric, false for arithmetic. */
    boolean type;

    /** Stores the index of the item that the user long-pressed. */
    int selectedIndex = -1;

    /**
     * Initializes the activity, populates the list with the progression, and sets up listeners.
     * <p>
     *
     * @param savedInstanceState If the activity is being re-initialized, this Bundle contains the most recent data.
     */
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

        // Populate the list based on the progression type
        if (type) { // Geometric
            for (int n = 0; n < 20; n++) {
                list[n] = (int) (a1 * Math.pow(q, n));
            }
        } else { // Arithmetic
            for (int n = 0; n < 20; n++) {
                list[n] = a1 + n * q;
            }
        }

        ArrayAdapter<Integer> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, list);
        lister.setAdapter(adapter);
        lister.setOnItemClickListener(this);
        lister.setOnCreateContextMenuListener(this);
    }

    /**
     * Creates the context menu when a user performs a long-press on a list item.
     * <p>
     *
     * @param menu The context menu that is being built.
     * @param v The view for which the context menu is being built.
     * @param menuInfo Extra information about the item for which the context menu should be shown.
     */
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) menuInfo;
        selectedIndex = info.position;

        menu.setHeaderTitle("what you want to know");
        menu.add("sum");
        menu.add("index");
    }

    /**
     * Handles the user's selection from the context menu.
     * <p>
     *
     * @param item The context menu item that was selected.
     * @return boolean Returns true to indicate the event was handled.
     */
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        String oper = item.getTitle().toString();
        int result;
        // The index is 0-based, so for calculations (n-th term), we add 1.
        int n = selectedIndex + 1;

        if (oper.equals("sum")) {
            if (type) { // Geometric sum
                if (q == 1) {
                    // Avoid division by zero and calculate sum for common ratio of 1
                    result = a1 * n;
                } else {
                    result = (int) (a1 * (Math.pow(q, n) - 1) / (q - 1));
                }
            } else { // Arithmetic sum
                result = n * (2 * a1 + (n - 1) * q) / 2;
            }
            ans.setText("Sum = " + result);

        } else if (oper.equals("index")) {
            ans.setText("Index = " + n);
        }

        return true;
    }



    /**
     * Handles clicks on individual items in the ListView. Currently does nothing.
     * <p>
     *
     * @param parent The AdapterView where the click happened.
     * @param view The view within the AdapterView that was clicked.
     * @param n The position of the view in the adapter.
     * @param id The row id of the item that was clicked.
     */
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int n, long id) {}


    /**
     * Inflates the options menu from a menu resource.
     * <p>
     *
     * @param menu The options menu in which items are placed.
     * @return boolean Returns true to display the menu.
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    /**
     * Handles clicks on the options menu items.
     * <p>
     *
     * @param item The menu item that was selected.
     * @return boolean Returns true to consume the event here.
     */
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
