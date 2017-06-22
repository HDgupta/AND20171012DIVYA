package com.example.http;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.StringRequest;

import com.example.http.domain.List;
import com.example.http.domain.Parse;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = MainActivity.class.getName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                App app = (App) getApplication();

                String lat = ((EditText)findViewById(R.id.edLat)).getText().toString();
                String lon = ((EditText)findViewById(R.id.edtLong)).getText().toString();

                final  ProgressDialog pd = ProgressDialog.show(MainActivity.this,"Inprogress","Loading data..");
                app.queue().add(new StringRequest("http://api.openweathermap.org/data/2.5/find?lat="+lat+"&lon="+lon+"&cnt=10&appid=eb5b07133b19a226621ddb469133f6aa", new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.i(TAG,"Response is -" +
                                response);

                        Parse m = ((App) getApplication()).gson().fromJson(response,Parse.class);
                        // String show = m.getMessage();

                        List lst = m.getList().get(0);
                        String show = ""+lst.getMain().getTemp();
                        ((TextView)findViewById(R.id.txtShow)).setText(show);
                        pd.dismiss();
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        //VolleyLog.wtf(error,"");
                        pd.dismiss();
                    }
                }));
            }


        });
    }

//    public void OnFind(View view){
//        App app = (App) getApplication();
//
//        String lat = ((EditText)findViewById(R.id.edLat)).getText().toString();
//        String lon = ((EditText)findViewById(R.id.edtLong)).getText().toString();
//
//        final  ProgressDialog pd = ProgressDialog.show(MainActivity.this,"Inprogress","Loading data..");
//        app.queue().add(new StringRequest("http://api.openweathermap.org/data/2.5/find?lat="+lat+"&lon="+lon+"&cnt=10&appid=eb5b07133b19a226621ddb469133f6aa", new Response.Listener<String>() {
//            @Override
//            public void onResponse(String response) {
//                Log.i(TAG,"Response is -" +
//                        response);
//
//                Parse m = ((App) getApplication()).gson().fromJson(response,Parse.class);
//               // String show = m.getMessage();
//
//                List lst = m.getList().get(0);
//               String show = lst.getMain().getTemp()+"";
//                ((TextView)findViewById(R.id.txtShow)).setText(show);
//                pd.dismiss();
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                //VolleyLog.wtf(error,"");
//                pd.dismiss();
//            }
//        }));
//    }
}


