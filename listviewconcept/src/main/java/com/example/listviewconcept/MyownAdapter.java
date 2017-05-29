package com.example.listviewconcept;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by divya on 29/5/17.
 */

public class MyownAdapter extends BaseAdapter {

    public Context context;
    public List<MyownItem> dataset;
    public LayoutInflater inflater;

    public MyownAdapter(Context context,List<MyownItem> dataset){

        this.context=context;
        this.dataset=dataset;
        inflater=LayoutInflater.from(context);

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
        return position*12 ;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View main=inflater.inflate(R.layout.myownview,parent,false);
        ((ImageView)main.findViewById(R.id.img1)).setImageResource(dataset.get(position).imgid);
        ((TextView)main.findViewById(R.id.txt1)).setText(dataset.get(position).text);
        return main;
    }
}
