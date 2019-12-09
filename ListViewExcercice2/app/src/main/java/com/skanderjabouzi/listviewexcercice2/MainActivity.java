package com.skanderjabouzi.listviewexcercice2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    ListAdapter adapter;

    public static List<String> lang = new ArrayList<String>() {{
        add("Java");
        add("C++");
        add("C#");
        add("HTML");
        add("PHP");
        add("Kotlin");
        add("CSS");
    }};


    public static List<Integer> image = new ArrayList<Integer>() {{
        add(R.drawable.java);
        add(R.drawable.cplus);
        add(R.drawable.csharp);
        add(R.drawable.html);
        add(R.drawable.php);
        add(R.drawable.kotlin);
        add(R.drawable.download);
    }};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listView);
        adapter = new ListAdapter(this, lang, image);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                        Intent intent = new Intent(getApplicationContext(), Main2Activity.class);
                        intent.putExtra("LANG", lang.get(position));
                        intent.putExtra("IMAGE", image.get(position));
                        intent.putExtra("POS", position);
                        startActivity(intent);
                    }
                }
        );
    }


    public void add(View view) {
        lang.add("Xkang");
        image.add(R.drawable.ic_launcher_background);
        adapter.notifyDataSetChanged();
    }

    public void delete(View view) {
        lang.remove(lang.size() -1);
        image.remove(lang.size() -1);
        adapter.notifyDataSetChanged();
    }
}
