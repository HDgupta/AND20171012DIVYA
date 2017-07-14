package com.example.wifi;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private WifiManager manager;
    private IntentFilter filter;

    private BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            List<ScanResult> scanResults = manager.getScanResults();
            for(ScanResult sc : scanResults){
                Log.i("@@@","SSID -" + sc.SSID + "BSSD -" + sc.BSSID );
            }
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        manager = (WifiManager) getApplicationContext().getSystemService(WIFI_SERVICE);
        filter = new IntentFilter(WifiManager.SCAN_RESULTS_AVAILABLE_ACTION);
    }

    @Override
    protected void onStart() {
        super.onStart();
        registerReceiver(broadcastReceiver,filter);
    }

    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(broadcastReceiver);
    }

    public void onConnected(View view){

        List<WifiConfiguration> nsc = manager.getConfiguredNetworks();
        for(WifiConfiguration nw :nsc){
            Log.i("@divya","SSID-" + nw.SSID +""+ "BSSID-" + nw.BSSID);
        }
    }

    public void onConnect(View view){

        WifiConfiguration wificonfig = new WifiConfiguration();
        wificonfig.SSID = String.format("\"%s\"","CSDSD");
        wificonfig.preSharedKey = String.format("\"%s\"","87654321");

        int netId = manager.addNetwork(wificonfig);
        manager.disconnect();
        manager.enableNetwork(netId,true);
        manager.reconnect();

    }

    public void onScan(View view){
        manager.startScan();
    }
}
