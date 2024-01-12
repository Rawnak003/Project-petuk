package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomAdapter extends BaseAdapter {

    int[] pic;
    String[] name;
    Context context;
    LayoutInflater inflater;

    CustomAdapter(Context context, String[] name, int[] pic){
        this.context = context;
        this.name = name;
        this.pic = pic;
    }

    @Override
    public int getCount() {
        return name.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup parent) {
        if(convertView == null){
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.sample, parent,false);
        }
        ImageView imageView = (ImageView) convertView.findViewById(R.id.imageId);
        TextView textView = (TextView) convertView.findViewById(R.id.textViewId);

        imageView.setImageResource(pic[i]);
        textView.setText(name[i]);
        return convertView;
    }
}