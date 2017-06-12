package com.example.sharedpreferences;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private SharedPreferences preferences;
    public static final String TAG = MainActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        preferences = getSharedPreferences("prefer",MODE_APPEND);
    }

    public void onWrite(View view){

        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean("mBoolean",true);
        editor.putFloat("mFloat",32.76f);
        editor.putString("mString","Divya");
        editor.apply();
    }

    public void onRead(View view){

        boolean bool = preferences.getBoolean("mBoolean",false);
        float flo = preferences.getFloat("mFloat",40.32f);
        String str = preferences.getString("mString",":)");
        Log.i(TAG,"Boolean-" + bool + "Float-" + flo + "String-" + str);
        ((TextView)findViewById(R.id.txtShow)).setText("Boolean-" + bool + "Float-" + flo + "String-" + str);

    }
}
