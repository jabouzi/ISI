package com.skanderjabouzi.fragmenttabandpager;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class TabsAdapter extends FragmentStatePagerAdapter {
    int mNumOfTabs;
    public TabsAdapter(FragmentManager fm, int NoofTabs){
        super(fm);
        this.mNumOfTabs = NoofTabs;
    }
    @Override
    public int getCount() {
        return mNumOfTabs;
    }
    @Override
    public Fragment getItem(int position){
        switch (position){
            case 0:
                Fragment1 f0 = new Fragment1();
                return f0;
            case 1:
                Fragment2 f1 = new Fragment2();
                return f1;
            case 2:
                Fragment3 f2 = new Fragment3();
                return f2;
            default:
                return null;
        }
    }
}
