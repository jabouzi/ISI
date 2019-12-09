package com.skanderjabouzi.dialogpreftoast;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        TextView textView = findViewById(R.id.text);
        Intent intent = getIntent();
        String text = intent.getStringExtra("EXTRA");
        int number = intent.getIntExtra("EXTRA2", 0);
        textView.setText(text + " - " + number);
    }
}
