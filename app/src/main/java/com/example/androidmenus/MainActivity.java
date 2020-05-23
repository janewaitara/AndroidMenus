package com.example.androidmenus;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView menuTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        menuTitle = findViewById(R.id.menuTitle);
        this.registerForContextMenu(menuTitle);//long pressing it will help us get the context menu
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.options_menu, menu);
        return true;
    }

    // handling the onClicks on the menu
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()) {
            case R.id.optionsMenuItem1:
                Toast.makeText(this, "Menu Item 1 clicked", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.optionsMenuItem2:
                Toast.makeText(this, "Menu Item 2 clicked", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.optionsMenuItem3:
                Toast.makeText(this, "Menu Item 3 clicked", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.optionsMenuItem4:
                Toast.makeText(this, "Menu Item 4 clicked", Toast.LENGTH_SHORT).show();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.floating_contextual_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {

        //handle contextual floating menu item click
        switch(item.getItemId()) {
            case R.id.contextualFMenuItem1:
                Toast.makeText(this, " Contextual Menu 1 clicked", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.contextualFMenuItem2:
                Toast.makeText(this, "Contextual Menu  2 clicked", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.contextualFMenuItem3:
                Toast.makeText(this, "Contextual Menu  3 clicked", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.contextualFMenuItem4:
                Toast.makeText(this, "Contextual Menu 4 clicked", Toast.LENGTH_SHORT).show();
                return true;

            default:
                return super.onContextItemSelected(item);
        }


    }
}
