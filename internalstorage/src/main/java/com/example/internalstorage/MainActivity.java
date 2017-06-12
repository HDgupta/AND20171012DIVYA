package com.example.internalstorage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

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
    }

    public void onWrite(View view){

        String name = "Divya";
        File file = null;
        try {
            file = getFilesDir();
            FileOutputStream fos = openFileOutput("My_File.txt",MODE_APPEND);
            fos.write(name.getBytes());
            fos.close();
            Log.i(TAG, "File saved at - "+file.getAbsolutePath());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Toast.makeText(this,"Saved Sucessfully" + file,Toast.LENGTH_SHORT).show();
    }

    public void onRead(View view){

        StringBuilder builder = new StringBuilder();
        try {

            FileInputStream fis = openFileInput("My_File.txt");
            while (true){
                int ch = fis.read();
                if(ch==-1)break;
                else builder.append((char) ch);
            }

            fis.close();
            ((TextView)findViewById(R.id.textView)).setText(builder.toString());
            Log.i(TAG,"Data is-" + builder.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Toast.makeText(this,"Showing successfully",Toast.LENGTH_SHORT).show();

    }
}
