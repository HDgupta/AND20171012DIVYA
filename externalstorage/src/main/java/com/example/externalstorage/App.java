package com.example.externalstorage;

import android.app.Application;

/**
 * Created by divya on 15/6/17.
 */

public class App extends Application {

    private Dbhelper dbhelper;

    @Override
    public void onCreate() {
        super.onCreate();

        dbhelper = new Dbhelper(this,"company.sqlite",null,1);
    }

    public Dbhelper dbhelper(){
        return dbhelper;
    }
}
