package com.example.activitylife;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        msgs("onCreate");
    }
    @Override
    protected void onRestart() {
        super.onRestart();
        msgs("onRestart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        msgs("onResume");
    }

    @Override
    protected void onStart() {
        super.onStart();
        msgs("onStart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        msgs("onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        msgs("onDestroy");
    }

    @Override
    protected void onPause() {
        super.onPause();
        msgs("onPause");
    }

    private void msgs(String msg){
        Toast.makeText(this,msg,Toast.LENGTH_LONG).show();
    }
}
