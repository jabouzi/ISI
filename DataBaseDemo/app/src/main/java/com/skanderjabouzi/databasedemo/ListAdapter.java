package com.skanderjabouzi.databasedemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class ListAdapter extends ArrayAdapter<City> {

    Context context;
    List<City> list;
    LayoutInflater inflater;

    public ListAdapter(@NonNull Context context, List<City> list) {
        super(context, R.layout.listview_layout, list);//
        this.context = context;
        this.list = list;
        inflater = (LayoutInflater.from(context));//
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View view, @NonNull ViewGroup parent) {
        view = inflater.inflate(R.layout.listview_layout, null);
        TextView city = view.findViewById(R.id.city);
        TextView country = view.findViewById(R.id.country);
        city.setText(list.get(position).city);
        country.setText(list.get(position).country);
        return view;
    }
}
