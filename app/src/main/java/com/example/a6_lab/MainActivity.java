package com.example.a6_lab;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    ArrayList<String> empty = new ArrayList<>();
    ListView listAll;
    ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, empty);
        ListView listView = (ListView) findViewById(R.id.listAll);
        listView.setAdapter(adapter);
    }

    public void onBtnClick(View view) {

        new DataLoader(){
            @Override
            public void onPostExecute(String[] result)
            {
                adapter.addAll(result);
                adapter.notifyDataSetChanged();

            }
        }.execute();
    }
}