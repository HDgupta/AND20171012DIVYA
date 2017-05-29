package com.example.listviewconcept;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        custom();

    }


    private void custom(){
        List<MyownItem> dataset=new ArrayList<>();
        dataset.add(new MyownItem(R.drawable.ic_cloud_black_24dp,"cloud"));
        dataset.add(new MyownItem(R.drawable.ic_favorite_black_24dp,"heart"));
        dataset.add(new MyownItem(R.drawable.ic_flash_on_black_24dp,"flash on"));
        dataset.add(new MyownItem(R.drawable.ic_flight_black_24dp,"flight"));

        MyownAdapter adapter=new MyownAdapter(this,dataset);
        ((ListView)findViewById(R.id.lstView)).setAdapter(adapter);

    }

    private void simple(){
        List<String> data=new ArrayList();
        data.add("C");
        data.add("C++");
        data.add("Java");
        data.add("Python");


        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,data);
        ((ListView)findViewById(R.id.lstView)).setAdapter(adapter);

        ((ListView)findViewById(R.id.lstView)).setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ArrayAdapter<String> adaplocal=(ArrayAdapter<String>)parent.getAdapter();
                String get=adaplocal.getItem(position);
                ((TextView)findViewById(R.id.edttxt)).setText(get);

            }
        });

    }
    public void addlang(View view) {
                ArrayAdapter<String> adapt  = (ArrayAdapter<String>) ((ListView) findViewById(R.id.lstView)).getAdapter();
                adapt.add(((EditText) findViewById(R.id.edttxt)).getText().toString());
                adapt.notifyDataSetChanged();
         }

}
