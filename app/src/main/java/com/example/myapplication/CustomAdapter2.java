package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomAdapter2 extends BaseAdapter {

    int[] pic;
    String[] Cname;
    Context context;
    LayoutInflater inflater;

    CustomAdapter2(Context context, String[] Cname, int[] pic){
        this.context = context;
        this.Cname = Cname;
        this.pic = pic;
    }

    @Override
    public int getCount() {
        return Cname.length;
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
            convertView = inflater.inflate(R.layout.sample2, parent,false);
        }
        ImageView imageView = (ImageView) convertView.findViewById(R.id.CategoryImageId);
        TextView textView = (TextView) convertView.findViewById(R.id.CategoryImageNameId);

        imageView.setImageResource(pic[i]);
        textView.setText(Cname[i]);
        return convertView;
    }
}