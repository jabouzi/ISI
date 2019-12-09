package com.skanderjabouzi.layoutinflater;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayout mainLayout = (LinearLayout) findViewById(R.id.activity_main_layout);

        // inflate (create) another copy of our custom layout
        LayoutInflater inflater = getLayoutInflater();
        View myLayout = inflater.inflate(R.layout.my_layout, mainLayout, false);

        // make changes to our custom layout and its subviews
        myLayout.setBackgroundColor(ContextCompat.getColor(this, R.color.colorAccent));
        TextView textView = (TextView) myLayout.findViewById(R.id.textView);
        textView.setText("New Layout");

        // add our custom layout to the main layout
        mainLayout.addView(myLayout);
    }
}
