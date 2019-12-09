package com.skanderjabouzi.listviewexcercice;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView simpleListView;
    ArrayAdapter<String> arrayAdapter;
    public static List<String> list = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        simpleListView = findViewById(R.id.simpleListView);
        arrayAdapter = new ArrayAdapter<>(this, R.layout.listview_layout, R.id.textView, list);
        simpleListView.setAdapter(arrayAdapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
//        arrayAdapter = new ArrayAdapter<>(this, R.layout.listview_layout, R.id.textView, list);
//        simpleListView.setAdapter(arrayAdapter);
        arrayAdapter.notifyDataSetChanged();
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
}
