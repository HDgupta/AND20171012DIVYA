package com.example.ui_thread;

import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    int i = 0;

    private Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //handler=new Handler(Looper.getMainLooper());
    }


    public void btnOkay(View view){
        handlerdemo();
    }

    private void simplerun(){


                for (i=0;i<100;i++){
                    try{
                        Thread.sleep(1000);
                    }catch(InterruptedException e){
                        e.printStackTrace();
                    }
                    ((TextView)findViewById(R.id.textView)).setText(""+i);
                }
    }


    private void Newthread(){

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (i=0;i<100;i++){
                    try{
                        Thread.sleep(1000);
                    }catch(InterruptedException e){
                        e.printStackTrace();
                    }
                    ((TextView)findViewById(R.id.textView)).setText(String.valueOf(i));
                }
            }
        }).start();

    }

    private void handlerdemo(){

        new Thread(new Runnable() {
            @Override
            public void run() {

                for(i=0;i<100;i++){
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    new Handler(Looper.getMainLooper()).post(new Runnable() {
                        @Override
                        public void run() {
                            ((TextView)findViewById(R.id.textView)).setText(String.valueOf(i));
                        }
                    });
                }
            }
        }).start();
    }
}

  