package com.example.notificationdialogs;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onAlert(View view){
        dialog(ApplDialog.TAG_AIRPLANE_MODE);
    }

    public void onDate(View view){
        dialog(ApplDialog.TAG_SHOW_CALENDAR);
    }

    public  void onTime(View view){
        dialog(ApplDialog.TAG_SHOW_TIME);
    }

    public void onProgress(View view){
        dialog(ApplDialog.TAG_SHOW_PROGRESS);
    }

    public void onCustom(View view){
        dialog(ApplDialog.TAG_CUSTOM);
    }

    public void dialog(String tag){
        ApplDialog dialog=new ApplDialog();
        dialog.show(getSupportFragmentManager(),tag);
    }


}
