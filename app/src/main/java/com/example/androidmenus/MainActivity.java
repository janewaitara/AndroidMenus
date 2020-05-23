package com.example.androidmenus;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.ActionMode;
import androidx.appcompat.widget.PopupMenu;

import android.os.Bundle;

import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {

    TextView menuTitle;
    Button btnActionModeMenu;

    ActionMode mActionMode;//object of the ActionMode class

    private ActionMode.Callback mActionModeCallback = new ActionMode.Callback() {
        @Override
        public boolean onCreateActionMode(ActionMode mode, Menu menu) {
            MenuInflater inflater = getMenuInflater();
            inflater.inflate(R.menu.actionmode_contextual_menu, menu);
            return true;
        }

        @Override
        public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
            return false;
        }

        @Override
        public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
            //handle contextual floating menu item click
            switch(item.getItemId()) {
                case R.id.actionContextualMenuItem1:
                    Toast.makeText(MainActivity.this, " Contextual Menu 1 clicked",
                            Toast.LENGTH_SHORT).show();
                    mode.finish();//ending the mode before it can start again
                    return true;

                case R.id.actionContextualMenuItem2:
                    Toast.makeText(MainActivity.this, "Contextual Menu  2 clicked",
                            Toast.LENGTH_SHORT).show();
                    mode.finish();
                    return true;

                case R.id.actionContextualMenuItem3:
                    Toast.makeText(MainActivity.this, "Contextual Menu  3 clicked",
                            Toast.LENGTH_SHORT).show();
                    return true;

                case R.id.actionContextualMenuItem4:
                    Toast.makeText(MainActivity.this, "Contextual Menu 4 clicked",
                            Toast.LENGTH_SHORT).show();
                    mode.finish();
                    return true;

                default:
                    return false;
            }
        }

        @Override
        public void onDestroyActionMode(ActionMode mode) {

            mActionMode = null;

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        menuTitle = findViewById(R.id.menuTitle);
        this.registerForContextMenu(menuTitle);//long pressing it will help us get the context menu

        btnActionModeMenu = findViewById(R.id.btnActionModeMenu);
        btnActionModeMenu.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {

                if (mActionMode != null) {
                    return false;
                }

                mActionMode = startSupportActionMode(mActionModeCallback); //instantiating ActionMode
                return true;
            }
        });
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

    public void showPopupMenu(View view) {
        PopupMenu mPopupMenu = new PopupMenu(this, view);//object of the PopupMenu class
        mPopupMenu.setOnMenuItemClickListener(this);
        mPopupMenu.inflate(R.menu.popup_menu); //inflate using the object
        mPopupMenu.show();

    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        //handle contextual floating menu item click
        switch(item.getItemId()) {
            case R.id.popupMenuItem1:
                Toast.makeText(this, " Contextual Menu 1 clicked", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.popupMenuItem2:
                Toast.makeText(this, "Contextual Menu  2 clicked", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.popupMenuItem3:
                Toast.makeText(this, "Contextual Menu  3 clicked", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.popupMenuItem4:
                Toast.makeText(this, "Contextual Menu 4 clicked", Toast.LENGTH_SHORT).show();
                return true;;+-

            default:
                return false;
        }


    }
}
