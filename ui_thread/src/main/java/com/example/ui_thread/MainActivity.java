package com.example.ui_thread;

import android.app.ProgressDialog;
import android.os.AsyncTask;
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
        new Mytask().execute(0,100);
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

    private class Mytask extends AsyncTask<Integer/*Params*/,Integer/*Progress*/,Boolean/*Result*/>{

        private ProgressDialog pd;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            //Ui thread
            pd = new ProgressDialog(MainActivity.this);
            pd.setMax(100);
            pd.setTitle("Progressbar");
            pd.setMessage("Loading..");
            pd.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
            pd.show();
        }

        @Override
        protected Boolean /*Result*/doInBackground(Integer... params) /*Params for execute method*/{
                /*Worker thread*/
            for(int i = params[0]; i < params[1]; i++){
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                publishProgress(i/*Progress*/);
            }
            return true;
        }

        @Override
        protected void onPostExecute(Boolean aBoolean/*Result*/) {
            super.onPostExecute(aBoolean);
            pd.dismiss();
            /*UI thread*/
        }

        @Override
        protected void onProgressUpdate(Integer... values/*Progress*/) {
            super.onProgressUpdate(values);

            ((TextView)findViewById(R.id.textView)).setText(String.valueOf(values[0]));
            pd.setProgress(values[i]);
            //ui thread
        }
    }

}

  