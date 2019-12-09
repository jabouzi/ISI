package com.skanderjabouzi.listviewdemo2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    String[] lang = {
            "Java",
            "C++",
            "C#",
            "HTML",
            "PHP",
            "Kotlin",
            "CSS"

    } ;


    int[] image = {
            R.drawable.java,
            R.drawable.cplus,
            R.drawable.csharp,
            R.drawable.html,
            R.drawable.php,
            R.drawable.kotlin,
            R.drawable.download

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listView1);
        ListAdapter adapter = new ListAdapter(this, lang, image);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                        Toast.makeText(getApplicationContext(), "You clicked " + position, Toast.LENGTH_SHORT).show();
                    }
                }
        );
    }
}
