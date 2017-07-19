package com.example.telephony;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TelephonyManager manager;
    private SmsManager smsManager;
    private PendingIntent intentSent,intentDelievered;

    private BroadcastReceiver receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            if(intent.getAction().equals("com.divya.sms.sent"))
                Toast.makeText(context,"Msg sent",Toast.LENGTH_SHORT).show();
            else if(intent.getAction().equals("com.divya.sms.delivered"))
                Toast.makeText(context,"Msg delivered",Toast.LENGTH_SHORT).show();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        manager = (TelephonyManager) getSystemService(TELEPHONY_SERVICE);
        smsManager = SmsManager.getDefault();

        Intent sent = new Intent("com.divya.sms.sent");
        intentSent  = PendingIntent.getBroadcast(this,123,sent,PendingIntent.FLAG_UPDATE_CURRENT);

        Intent deliever = new Intent("com.divya.sms.delivered");
        intentDelievered  = PendingIntent.getBroadcast(this,456,deliever,PendingIntent.FLAG_UPDATE_CURRENT);

        IntentFilter filter = new IntentFilter();
        filter.addAction("com.divya.sms.sent");
        filter.addAction("com.divya.sms.delivered");

        registerReceiver(receiver,filter);

        info();
    }

    private void info() {
        int dataactivity = manager.getDataActivity();
        int callstate = manager.getCallState();
         String imei = manager.getDeviceId();
        Log.i("@@@","Imei - " + imei);
        Log.i("@@@","Number - " + manager.getLine1Number());
        Log.i("@@@","operator - " + manager.getSimOperator());
        Log.i("@@@","country - " + manager.getSimCountryIso());
        Log.i("@@@","operator name - " + manager.getSimOperatorName());
    }

    public void onSend(View view){
        String no = ((EditText)findViewById(R.id.edtNo)).getText().toString();
        smsManager.sendTextMessage(no,null,"Welcome to wedding app.Your id is 34555 and password is 456",intentSent,intentDelievered);
    }

}