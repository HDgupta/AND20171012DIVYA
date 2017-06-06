package com.example.statusbarnotifications;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private NotificationManager notificationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
    }

    public void showNotification(View view) {

        Intent intent = new Intent(this,NotificationActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this,1234,intent,PendingIntent.FLAG_ONE_SHOT);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);

        builder.setContentTitle("Screenshot Captured")
                .setContentInfo("Touch to view your screenshot")
                .setSmallIcon(R.drawable.ic_note_black_24dp)
                .setAutoCancel(true)
                .setOngoing(false)
                .setWhen(System.currentTimeMillis())
                //.setContentText("Displaying notification")
                .setDefaults(Notification.DEFAULT_ALL)
                .setContentIntent(pendingIntent)
                .addAction(R.mipmap.ic_launcher_round,"Next",pendingIntent)
                ;

            Notification notification=builder.build();
            notificationManager.notify(1234,notification);


    }
}