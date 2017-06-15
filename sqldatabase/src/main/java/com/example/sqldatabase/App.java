package com.example.sqldatabase;

import android.app.Application;

/**
 * Created by divya on 15/6/17.
 */

public class App extends Application {

    private Dbhelper helper;

    @Override
    public void onCreate() {
        super.onCreate();

        helper = new Dbhelper(this,"company.sqlite",null,1);
    }

    public Dbhelper helper(){
        return helper;
    }
}
