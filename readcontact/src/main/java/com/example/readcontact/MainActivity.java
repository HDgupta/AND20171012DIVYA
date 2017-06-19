package com.example.readcontact;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyOwnconPro();


        //showing our own contactlist
        //ReadContacts();
    }

    private void ReadContacts() {

        List<String> list = new ArrayList<>();
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, list);

        ContentResolver resolver = getContentResolver();
       Cursor cursor = resolver.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                new String[]{ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME,
                        ContactsContract.CommonDataKinds.Phone.NUMBER}
        ,null
        ,null
        ,null);

        while (cursor.moveToNext()){
            String name = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
            String number = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
            list.add(name +"\n" +number);
        }

        ((ListView)findViewById(R.id.contactLst)).setAdapter(adapter);
    }

    private void MyOwnconPro(){

        List<String> list = new ArrayList<>();
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, list);

        ContentResolver resolver = getContentResolver();

        Cursor cursor = resolver.query(Uri.parse("content://com.contactprovider.read")
        ,new String[]{"name","type","no","qaunt"}
                ,null
                ,null
                ,null);

        if(cursor!=null) {
            while (cursor.moveToNext()) {
                String name = cursor.getString(cursor.getColumnIndex("name"));
                String type = cursor.getString(cursor.getColumnIndex("type"));
                int no = cursor.getInt(cursor.getColumnIndex("no"));
                int qaunt = cursor.getInt(cursor.getColumnIndex("qaunt"));
                list.add(name + "\n" + type + "\n" + no + "\n" + qaunt);
            }
        }

        ((ListView)findViewById(R.id.contactLst)).setAdapter(adapter);

    }
}