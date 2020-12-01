package com.example.a6_lab;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;


public class MainActivity extends AppCompatActivity {

    ListView listAll;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.listAll = findViewById(R.id.listAll);
    }

    public void onBtnClick(View view) {

        new DataLoader(){
            @Override
            public void onPostExecute(String result)
            {
                listAll.add(result);
            }
        }.execute("USD");
    }
}