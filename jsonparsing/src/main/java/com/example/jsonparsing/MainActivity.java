package com.example.jsonparsing;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = MainActivity.class.getName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //parsingNativemethod();
        parsingUsingGson();
    }

    private void parsingNativemethod(){

        String json = Support.readAsset(this);
        Log.i(TAG,"We have our json as -" + json);

        try {
            JSONObject obj = new JSONObject(json);
            Log.i(TAG,"Language name" + obj.getString("NewLang"));
            Log.i(TAG,"Time" + obj.getString("famous"));

            JSONArray OldLang = obj.getJSONArray("OldLang");
            for( int i=0; i<OldLang.length();i++)
            Log.i(TAG,"Name - " + OldLang.getString(i));

            JSONObject studentname = obj.getJSONObject("studentname");
            Log.i(TAG,"Studentname -" + studentname.getString("name"));
            Log.i(TAG,"Studentid -" + studentname.getString("id"));

            JSONArray courses = obj.getJSONArray("courses");
            for( int i=0;i<courses.length();i++){
                JSONObject course = courses.getJSONObject(i);
                Log.i(TAG,"Course Name - " + course.getString("name"));
                Log.i(TAG,"Course id - " + course.getInt("id"));

            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void parsingUsingGson(){
        Gson gson = new Gson();
        Parsing my = gson.fromJson(Support.readAsset(this),Parsing.class);
        Log.i(TAG,"New Lang -" + my.getNewLang() + "\n" + "Famous -" + my.getFamous());

        for (String ol : my.getOldLang()){
            Log.i(TAG,"Stu -" + ol);
        }

        Studentname stdt = my.getStudentname();
        Log.i(TAG,"Name -" + stdt.getName()+ "\n" + "id -" + stdt.getId());

        for(Course cou : my.getCourses()){
            Log.i(TAG,"Course name -" +cou.getName() +"\n"+" COurse id-" + cou.getId());
        }

    }
}
