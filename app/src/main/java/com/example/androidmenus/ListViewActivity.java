package com.example.androidmenus;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

public class ListViewActivity extends AppCompatActivity {

    private ListView mListView;
    ArrayList<String> planetList;
    private ArrayAdapter<String> listAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        mListView = (ListView) findViewById(R.id.listViewId);

        //creating and populating a list of planet names
        String[] planets = new String[]{"Mercury", "Venus", "Earth", "Mars",
                "Jupiter", "Saturn", "Uranus", "Neptune"};
        planetList = new ArrayList<String>();
        planetList.addAll(Arrays.asList(planets));

        //creating an arrayAdapter using the planet List
        listAdapter = new ArrayAdapter<String>(this, R.layout.list_simplerow, planetList);

        //setting the arrayAdapter as the ListView Adapter
        mListView.setAdapter(listAdapter);

        //enables selection of many items
        mListView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE_MODAL);

        mListView.setMultiChoiceModeListener(new AbsListView.MultiChoiceModeListener() {
            @Override
            public void onItemCheckedStateChanged(ActionMode mode, int position, long id, boolean checked) {

                //does something when you select or de-select an item
            }

            @Override
            public boolean onCreateActionMode(ActionMode mode, Menu menu) {
                //inflate the menu
                MenuInflater menuInflater = getMenuInflater();
                menuInflater.inflate(R.menu.batchcontextual_menu, menu);
                return true;
            }

            @Override
            public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
                return false;
            }

            @Override
            public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
                //take action when a menu is clicked
                switch (item.getItemId()){
                    case R.id.listDelete:
                        deleteSelectedItem();
                        mode.finish();
                        return true;
                    default:
                        return false;

                }
            }

            @Override
            public void onDestroyActionMode(ActionMode mode) {

            }
        });

    }

    private void deleteSelectedItem() {

        // Getting the checked Item from the listView
        SparseBooleanArray checkedItemPositions = mListView.getCheckedItemPositions();
        int itemCount = mListView.getCount();

        for (int i = itemCount - 1; i >= 0; i--) {
            if (checkedItemPositions.get(i)) {
                listAdapter.remove(planetList.get(i));
            }
        }
        checkedItemPositions.clear();
        listAdapter.notifyDataSetChanged();

    }
}
