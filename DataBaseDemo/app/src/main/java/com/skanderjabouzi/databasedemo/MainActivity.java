package com.skanderjabouzi.databasedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    ListAdapter adapter;
    CityDataSource cityDataSource;

    public static List<City> list = new ArrayList<City>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cityDataSource = new CityDataSource(this);
        if (!cityDataSource.isOpen()) cityDataSource.open();

        listView = findViewById(R.id.listView);
        adapter = new ListAdapter(this, list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                    }
                }
        );
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (!cityDataSource.isOpen()) cityDataSource.open();
        list.clear();
        for(City city : cityDataSource.getAllCities()) {
            list.add(city);
        }
        Log.e("LIST", list.toString());
        adapter.notifyDataSetChanged();
        if (cityDataSource.isOpen()) cityDataSource.close();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.add) {
            Intent intent = new Intent(getApplicationContext(), Main2Activity.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
