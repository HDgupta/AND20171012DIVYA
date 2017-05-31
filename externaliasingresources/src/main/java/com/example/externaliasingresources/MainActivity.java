package com.example.externaliasingresources;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String [] states = getResources().getStringArray(R.array.states);

        String text = getResources().getString(R.string.text);

        int color=getResources().getColor(R.color.faintgray);
        color= ContextCompat.getColor(this,R.color.colorPrimaryDark);
    }
}
