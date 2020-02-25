package com.skanderjabouzi.listview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView simpleListView;
    ListView simpleListView2;
    public static List<String> list = new ArrayList<String>() {{
        add("s1");
        add("s2");
        add("s3");
    }};
    ArrayAdapter<String> arrayAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SharedPreferences preferences = getSharedPreferences("app", MODE_PRIVATE);
//        list.add("India");
//        list.add("China");
//        list.add("australia");
//        list.add("Portugle");
//        list.add("America");
//        list.add("NewZealand");


        simpleListView = findViewById(R.id.simpleListView);
        simpleListView2 = findViewById(R.id.simpleListView2);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        super.onOptionsItemSelected(item);

        switch (item.getItemId()) {
            case R.id.add:
                Intent intent = new Intent(this, Main2Activity.class);
                startActivity(intent);
                return true;
            default:
                return false;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        arrayAdapter = new ArrayAdapter<>(this, R.layout.listview_layout, R.id.textView, list);
        simpleListView.setAdapter(arrayAdapter);
        simpleListView2.setAdapter(arrayAdapter);
    }
}
