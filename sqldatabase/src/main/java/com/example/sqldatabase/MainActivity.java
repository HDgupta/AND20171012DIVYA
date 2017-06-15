package com.example.sqldatabase;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onInsert(View view){

        inserteasily();

    }


    public void onUpdate(View view){

        App app = (App) getApplication();

        String table = "CompData";
        ContentValues values = new ContentValues();
        values.put("name","hero");
        String whereClause = "qaunt = ?";
        String[] whereArgs = {"100"};

        SQLiteDatabase sqlDb = app.helper().getWritableDatabase();
        int reflected = sqlDb.update(table,values,whereClause,whereArgs);
        Log.i("@codekul", "" + reflected + " rows reflected ");
        sqlDb.close();
    }

    public void onDelete(View view){

        App app = (App) getApplication();

        String table ="CompData";
        String whereClause = "type = ?";
        String[] whereArgs = {"car"};

        SQLiteDatabase sqlDb = app.helper().getWritableDatabase();
        int deleted  = sqlDb.delete(table,whereClause,whereArgs);
        Log.i("@codekul", "" + deleted + " rows deleted");
        sqlDb.close();
    }

    public void onDisplay(View view){

        displayall();

    }

    private void displaytype(){

        App app = (App) getApplication();
        SQLiteDatabase sqldb = app.helper().getReadableDatabase();

        String table = "CompData";
        String[] columns = {"type"};
        String selection = "name = ?";
        String[] selectionArgs = {"honda"};
        String groupBy = null;
        String having = null;
        String orderBy = null;

        Cursor cursor = sqldb.query(table,columns,selection,selectionArgs,groupBy,having,orderBy);

        while (cursor.moveToNext()){
            String tp = cursor.getString(1);
            ((TextView)findViewById(R.id.textView)).setText("\n" +"type -" +tp );
        }
        cursor.close();
        sqldb.close();
    }

    private void displayall(){
        App app = (App) getApplication();
        SQLiteDatabase sqldb = app.helper().getReadableDatabase();

        String table = "CompData";
        String[] columns = null;
        String selection = null;
        String[] selectionArgs = null;
        String groupBy = null;
        String having = null;
        String orderBy = null;

        Cursor cursor = sqldb.query(table,columns,selection,selectionArgs,groupBy,having,orderBy);

        while (cursor.moveToNext()){
            String nm = cursor.getString(0);
            String tp = cursor.getString(1);
            int num = cursor.getInt(2);
            int qt = cursor.getInt(3);

            //((TextView)findViewById(R.id.textView)).setText("name -" + nm +"\n" +"type -" +tp + "\n" +"no. -" + num +"\n"+ "quant- "+ qt );
            Log.i("@codekul", "name -" + nm +"\n" +"type -" +tp + "\n" +"no. -" + num +"\n"+ "quant- "+ qt);
        }
        cursor.close();
        sqldb.close();
    }

    private void insertorm(){
        App app = (App) getApplication();

        String table = "CompData";
        String nullColumnHack = null;

        ContentValues values = new ContentValues();
        values.put("name","honda");
        values.put("type","car");
        values.put("no",1);
        values.put("qaunt",100);

        SQLiteDatabase sqlDb = app.helper().getWritableDatabase();
        Long row = sqlDb.insert(table,nullColumnHack,values);
        if(row<0)((TextView)findViewById(R.id.textView)).setText("Error in insertion");
        else //((TextView)findViewById(R.id.textView)).setText("Inserted row sucessfully");
            Log.i("@codekul", " Inserted row sucessfully ");
        sqlDb.close();
    }

    private void inserteasily(){

        App app = (App) getApplication();
        SQLiteDatabase sqlDb = app.helper().getWritableDatabase();
        sqlDb.execSQL("insert into CompData values('tvs','scooty','2','200')");
        sqlDb.close();
    }






}
