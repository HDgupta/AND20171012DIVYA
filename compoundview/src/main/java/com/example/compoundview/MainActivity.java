package com.example.compoundview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Checkable;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private LayoutInflater inflater;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inflater= (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
        inflater= LayoutInflater.from(this);
    }

    public void Dynamic(final View view){

        FrameLayout frame1= (FrameLayout) findViewById(R.id.flayout1);
        frame1.removeAllViews();
        FrameLayout frame2= (FrameLayout) findViewById(R.id.flayout2);
        frame2.removeAllViews();


        final View viewinflated1=inflater.inflate(R.layout.compound_view,frame1,true);
        ((CheckBox)viewinflated1.findViewById(R.id.chkbx)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                ((TextView)viewinflated1.findViewById(R.id.txt)).setText(Boolean.toString(isChecked));
            }
        });

        final View viewinflated2=inflater.inflate(R.layout.compound_view,frame2,true);
        ((CheckBox)viewinflated2.findViewById(R.id.chkbx)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                ((TextView)viewinflated2.findViewById(R.id.txt)).setText(Boolean.toString(isChecked));
            }
        });

    }
}
