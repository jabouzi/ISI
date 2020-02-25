package com.skanderjabouzi.database;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;

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
    PersonDataSource personDataSource;
    LocalDataSource localDataSource;

    public static List<Person> list = new ArrayList<Person>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listView);
//        personDataSource = new PersonDataSource(this);
//        if (!personDataSource.isOpen()) personDataSource.open();

        localDataSource = new LocalDataSource(this);

    }

    @Override
    protected void onResume() {
        super.onResume();
        updatePersonsList();
//        if (!personDataSource.isOpen()) personDataSource.open();
//        List<Person> _list = personDataSource.getAllPersons();
//        LiveData<List<Person>> _list = localDataSource.getTasks();
//        list.clear();
//        for( Person person : _list.getValue()) {
//            list.add(person);
//        }
//        Log.e("LIST", list.toString());
//        adapter.notifyDataSetChanged();
//        if (personDataSource.isOpen()) personDataSource.close();
    }

    private void updatePersonsList() {
        localDataSource.getTasks().observe(this, new Observer<List<Person>>() {
            @Override
            public void onChanged(@Nullable final List<Person> personList) {
                if(personList.size() > 0) {
                    if (adapter == null) {
                    adapter = new ListAdapter(getApplicationContext(), personList);
                    listView.setAdapter(adapter);
                    listView.setOnItemClickListener(
                            new AdapterView.OnItemClickListener() {
                                @Override
                                public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                                    Intent intent = new Intent(getApplicationContext(), DetailActivity.class);
                                    Log.e("PERSON", ""+position);
                                    intent.putExtra("ID", personList.get(position).getId());
                                    startActivity(intent);
                                }
                            }
                    );

                    } else {
                        adapter.addPersons(personList);
                        adapter.notifyDataSetChanged();
                    }
                }
            }
        });
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
            Intent intent = new Intent(getApplicationContext(), DetailActivity.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
