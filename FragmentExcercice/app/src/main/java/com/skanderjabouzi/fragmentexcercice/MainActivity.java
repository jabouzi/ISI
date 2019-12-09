package com.skanderjabouzi.fragmentexcercice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.fragment12, Fragment1.newInstance("", ""));
        ft.replace(R.id.fragment21, Fragment2.newInstance("", ""));
        ft.commit();
    }

    public void swipe(View view) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.fragment12, Fragment2.newInstance("", ""));
        ft.replace(R.id.fragment21, Fragment1.newInstance("", ""));
        ft.commit();
    }
}
