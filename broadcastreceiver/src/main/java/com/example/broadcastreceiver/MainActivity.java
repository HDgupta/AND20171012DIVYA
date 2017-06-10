package com.example.broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            if(intent.getBooleanExtra("state",false)) {
                changeImage(R.drawable.ic_airplanemode_active_black_24dp);
                Toast.makeText(context, "Enabled", Toast.LENGTH_SHORT).show();
            }
            else {
                changeImage(R.drawable.ic_airplanemode_inactive_black_24dp);
                Toast.makeText(context,"Disabled",Toast.LENGTH_SHORT).show();
                }
            }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initflightmodechange();

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v.getId()==R.id.button){
                    sendBroadcast(new Intent("CUSTOM_RECEIVER"));
                }
            }
        });

    }




    private void initflightmodechange(){
        IntentFilter filter = new IntentFilter();
        filter.addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED);
        registerReceiver(broadcastReceiver,filter);
    }

    private void changeImage(int img){
        ((ImageView)findViewById(R.id.imageView)).setImageResource(img);
    }
}
