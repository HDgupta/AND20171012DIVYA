package com.example.activitystatemangement;

import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Date;

public class MainActivity extends AppCompatActivity {

    public static final String KEY_STR= "date";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        if(savedInstanceState!=null){
//            ((TextView)findViewById(R.id.txt)).setText(savedInstanceState.getString(KEY_STR));}
        msgs("OnCreate");
    }


    public void changes(View view)
    {
        ((TextView)findViewById(R.id.txt)).setText(new Date().toString());

    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        if(savedInstanceState!=null){
            ((TextView)findViewById(R.id.txt)).setText(savedInstanceState.getString(KEY_STR));
        }

    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(KEY_STR,((TextView)findViewById(R.id.txt)).getText().toString());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        msgs("OnDestroy");
    }

    private void msgs(String msg){
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }
}
