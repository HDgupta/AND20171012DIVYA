package com.example.externalstorage;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = MainActivity.class.getName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        appPrivateWrite();
        appPrivateRead();

//        publicappWrite();
//        publicappRead();
    }

    private void appPrivateWrite(){
        // File file = new File(getExternalFilesDir(""),"my.txt");
        File file = new File(getExternalFilesDir(Environment.DIRECTORY_MUSIC),"myfiles.txt");
        Log.i(TAG,"File path-" + file.getAbsolutePath());
        try {
            FileOutputStream fos = new FileOutputStream(file);
            fos.write("Concept of external storage".getBytes());
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void appPrivateRead()  {

        StringBuilder builder = new StringBuilder();
        File file = new File(getExternalFilesDir(Environment.DIRECTORY_MUSIC),"myfiles.txt");
        try {
            FileInputStream fis = new FileInputStream(file);
            while (true){
                int ch = fis.read();
                if(ch == -1)break;
                else
                    builder.append((char) ch);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Log.i(TAG,"Read Content" + builder.toString());

    }

    private void publicappWrite(){

        if(isMediaAvailable()) {
            File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM), "my.txt");
            Log.i(TAG, "File path-" + file.getAbsolutePath());
            try {
                FileOutputStream fos = new FileOutputStream(file);
                fos.write("Concept of external storage".getBytes());
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else
            Log.i(TAG, " Media Not Available");
    }

    private void publicappRead(){

        if(isMediaAvailable()) {

            StringBuilder builder = new StringBuilder();
            File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM), "my.txt");
            try {
                FileInputStream fis = new FileInputStream(file);
                while (true) {
                    int ch = fis.read();
                    if (ch == -1) break;
                    else
                        builder.append((char) ch);
                }fis.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Log.i(TAG, "Read Content" + builder.toString());
        }
        else
            Log.i(TAG, "Not Available");


    }

    private Boolean isMediaAvailable(){
        return Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED);
    }

}
