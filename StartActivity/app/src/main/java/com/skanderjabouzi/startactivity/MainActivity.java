package com.skanderjabouzi.startactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void changeText(View view) {
//        Intent intent = new Intent(this, Main2Activity.class);
//        intent.putExtra("EXTRA", "some text");
//        intent.putExtra("EXTRA2", 100);
//        startActivity(intent);

        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.vogella.com/"));
        startActivity(i);
    }

}
