package com.example.a6_lab;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class MainActivity extends AppCompatActivity {
    String[] empty = new String[0];
    ListView listAll;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.listAll = findViewById(R.id.listAll);
        ArrayAdapter adapter = new ArrayAdapter<String>(this,R.layout.activity_main,empty);
        listAll.setAdapter(adapter);
    }

    public void onBtnClick(View view) {

        new DataLoader(){
            @Override
            public void onPostExecute(String[] result)
            {
                empty = result;
            }
        }.execute();
    }
}