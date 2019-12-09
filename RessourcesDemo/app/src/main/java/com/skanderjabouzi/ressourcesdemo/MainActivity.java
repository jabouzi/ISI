package com.skanderjabouzi.ressourcesdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void changeImage(View view) {
        ImageView imageView = findViewById(R.id.imageView);
        imageView.setImageDrawable(getResources().getDrawable(R.drawable.img2));
        TextView textView = findViewById(R.id.textView);
        textView.setText(getResources().getString(R.string.image2));
        textView.setTextColor(ContextCompat.getColor(this, R.color.image2));
    }
}
