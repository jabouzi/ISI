package com.skanderjabouzi.listviewexcercice2;

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

public class ListAdapter extends ArrayAdapter<String> {

    Context context;
    List<String> langlist;
    List<Integer> images;
    LayoutInflater inflater;

    public ListAdapter(@NonNull Context context, List<String> langs, List<Integer> imgs) {
        super(context, R.layout.listview_layout, langs);//
        this.context = context;
        langlist = langs;
        images = imgs;
        inflater = (LayoutInflater.from(context));//
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View view, @NonNull ViewGroup parent) {
        view = inflater.inflate(R.layout.listview_layout, null);
        TextView text = view.findViewById(R.id.text);
        ImageView image = view.findViewById(R.id.image);
        text.setText(langlist.get(position));
        image.setImageResource(images.get(position));
        return view;
    }
}
