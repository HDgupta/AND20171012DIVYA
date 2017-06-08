package com.example.myfirstbigproj;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.List;

public class Dashboard extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);


           Player_list. dataset.add(new MyownItem("Sachin", "50yrs", R.mipmap.ic_launcher,""));
        Player_list.dataset.add(new MyownItem("Ms Dhoni", "45yrs", R.mipmap.ic_launcher_round,""));
        Player_list.dataset.add(new MyownItem("Virat Kholi", "35yrs", R.mipmap.ic_launcher,""));
        Player_list.dataset.add(new MyownItem("Sewag", "43yrs", R.mipmap.ic_launcher,""));
        Player_list.dataset.add(new MyownItem("Pandey", "38yrs", R.mipmap.ic_launcher_round,""));

            final MyAdapter adapter = new MyAdapter(this, Player_list.dataset);
            ((ListView) findViewById(R.id.lstView)).setAdapter(adapter);

            ((ListView) findViewById(R.id.lstView)).setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    MyownItem myownItem = (MyownItem) adapter.getItem(position);
                    startActivityForResult( new Intent(Dashboard.this, DetailedInfo.class),123);
                }
            });


        }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        ((MyAdapter) ((ListView) findViewById(R.id.lstView)).getAdapter()).notifyDataSetChanged();
    }
}

