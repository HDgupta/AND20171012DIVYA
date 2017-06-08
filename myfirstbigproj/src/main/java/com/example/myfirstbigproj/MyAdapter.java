package com.example.myfirstbigproj;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by divya on 7/6/17.
 */

public class MyAdapter extends BaseAdapter {

    public Context context;
    public List<MyownItem> dataset;
    public LayoutInflater inflater;

    public MyAdapter(Context context,List<MyownItem> dataset)
    {
        this.context=context;
        this.dataset=dataset;

        inflater = LayoutInflater.from(context);
    }
    @Override
    public int getCount() {
        return dataset.size();
    }

    @Override
    public Object getItem(int position) {
        return dataset.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View root = null;

        if(convertView == null)
            root = inflater.inflate(R.layout.compund_view3,parent,false);
        else
            root = convertView;

        ((ImageView)root.findViewById(R.id.imgPlayer2)).setImageResource(dataset.get(position).img);
        ((TextView)root.findViewById(R.id.txtName2)).setText(dataset.get(position).text);
        ((TextView)root.findViewById(R.id.txtAge2)).setText(dataset.get(position).text1);


        return root;
    }
}
