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

/**
 * @author        benjamin rogachevsky
 * @version       1.0
 * @since         1/7/26
 * This activity serves as the main screen, allowing users to define a numerical progression.
 */
public class MainActivity extends AppCompatActivity {

    /** EditText for the first term of the progression (a1). */
    EditText a1;
    /** EditText for the common difference or ratio (q). */
    EditText q;
    /** Button to trigger the display of the progression. */
    Button sent;
    /** Switch to select the type of progression (geometric or arithmetic). */
    Switch type;



    /**
     * Called when the activity is first created. Initializes the UI components.
     * <p>
     *
     * @param savedInstanceState If the activity is being re-initialized, this Bundle contains the most recent data.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        a1 = findViewById(R.id.a1);
        q = findViewById(R.id.q);
        sent = findViewById(R.id.sent);
        type = findViewById(R.id.swich);

    }


    /**
     * Creates and starts an Intent to show the progression activity.
     * <p>
     *
     * @param view The view that was clicked to trigger this method.
     */
    public void send(View view) {

        Intent shaw = new Intent(this, progression.class);


        if (!a1.getText().toString().equals(""))  shaw.putExtra("a1", Integer.parseInt(a1.getText().toString()));

        if (!q.getText().toString().equals("")) shaw.putExtra("q", Integer.parseInt(q.getText().toString()));
        shaw.putExtra("type", type.isChecked());

        startActivity(shaw);

    }



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
            Intent kuku = new Intent(this, MyActivityName.class);
            startActivity(kuku);
        }

        return super.onOptionsItemSelected(item);
    }
}
