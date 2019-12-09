package com.skanderjabouzi.fragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.fragment1, Fragment1.newInstance("", ""));
        ft.replace(R.id.fragment2, Fragment2.newInstance("", ""));
        ft.replace(R.id.fragment3, Fragment2.newInstance("", ""));
        ft.commit();
    }

    public void replace(View view) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.fragment3, Fragment1.newInstance("", ""));
        ft.commit();
    }
}
