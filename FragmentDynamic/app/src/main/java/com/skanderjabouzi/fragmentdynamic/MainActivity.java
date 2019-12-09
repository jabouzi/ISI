package com.skanderjabouzi.fragmentdynamic;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setFragment(Fragment1.newInstance(), R.id.frameLayout1);
        setFragment(Fragment2.newInstance(), R.id.frameLayout2);
    }

    private void setFragment(Fragment fragment, int viewId) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.replace(viewId, fragment);
        fragmentTransaction.commit();
    }
}
