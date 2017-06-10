package com.example.broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i("divya","Incoming action-"+intent.getAction());
        Toast.makeText(context,"Airplane mode enabled",Toast.LENGTH_SHORT).show();
    }
}
