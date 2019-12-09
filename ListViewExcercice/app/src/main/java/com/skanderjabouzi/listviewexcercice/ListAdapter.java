package com.skanderjabouzi.listviewexcercice;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;

public class ListAdapter extends ArrayAdapter<String> {

    Context context;
    String[] langList;
    int[] images;
    LayoutInflater inflater;

    public ListAdapter(@NonNull Context context, String[] langs, int[] imgs) {
        super(context, R.layout.listview_layout, langs);//
        this.context = context;
        langList = langs;
        images = imgs;
        inflater = (LayoutInflater.from(context));//
    }
}
