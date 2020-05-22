package com.example.androidmenus;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.options_menu, menu);
        return true;
    }

    // handling the onclicks on the menu
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.optionsMenuItem1:
                Toast.makeText(this, "Menu Item 1 clicked", Toast.LENGTH_SHORT).show();

            case R.id.optionsMenuItem2:
                Toast.makeText(this, "Menu Item 2 clicked", Toast.LENGTH_SHORT).show();

            case R.id.optionsMenuItem3:
                Toast.makeText(this, "Menu Item 3 clicked", Toast.LENGTH_SHORT).show();

            case R.id.optionsMenuItem4:
                Toast.makeText(this, "Menu Item 4 clicked", Toast.LENGTH_SHORT).show();
        }

        return super.onOptionsItemSelected(item);
    }
}
