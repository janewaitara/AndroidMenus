package com.example.androidmenus;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
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

        mListView =(ListView) findViewById(R.id.listViewId);

        //creating and populating a list of planet names
        String[] planets = new String[]{"Mercury","Venus","Earth","Mars",
                "Jupiter","Saturn","Uranus","Neptune" };
        planetList = new ArrayList<String>();
        planetList.addAll(Arrays.asList(planets));

        //creating an arrayAdapter using the planet List
        listAdapter = new ArrayAdapter<String>(this, R.layout.list_simplerow, planetList);

        //setting the arrayAdapter as the ListView Adapter
        mListView.setAdapter(listAdapter);

    }
}
