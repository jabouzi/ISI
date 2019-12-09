package com.skanderjabouzi.listviewexcercice2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

public class Main2Activity extends AppCompatActivity {

    int position;
    EditText editText;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent intent = getIntent();
        editText = findViewById(R.id.editText);
        imageView = findViewById(R.id.image);

        editText.setText(intent.getStringExtra("LANG"));
        imageView.setImageResource(intent.getIntExtra("IMAGE", 0));
        position = intent.getIntExtra("POS", 0);
    }

    public void update(View view) {
        MainActivity.lang.set(position, editText.getText().toString());
    }
}
