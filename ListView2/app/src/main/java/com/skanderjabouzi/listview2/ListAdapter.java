package com.skanderjabouzi.listview2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ListAdapter extends ArrayAdapter<String> {

    Context context;
    String[] langList;
    int[] images;
    LayoutInflater inflter;

    public ListAdapter(Context context, String[] langList, int[] images) {
        super(context, R.layout.listview_layout, langList);
        this.context = context;
        this.langList = langList;
        this.images = images;
        inflter = (LayoutInflater.from(context));

//        LayoutInflater vs findViewById.
//
//        LayoutInflater is used to create a new View (or Layout) object from one of your xml layouts.
//                findViewById just gives you a reference to a view than has already been created. You might think that you haven't created any views yet, but whenever you call setContentView in onCreate, the activity's layout along with its subviews gets inflated (created) behind the scenes.
//        So if the view already exists, then use findViewById. If not, then create it with a LayoutInflater.

    }


    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflter.inflate(R.layout.listview_layout, null);
        TextView lang = view.findViewById(R.id.text);
        ImageView image = view.findViewById(R.id.image);
        lang.setText(langList[i]);
        image.setImageResource(images[i]);
        return view;
    }
}
