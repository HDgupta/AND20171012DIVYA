package com.example.myfirstbigproj;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class
MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((Button)findViewById(R.id.btnLogin)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String username = ((EditText)findViewById(R.id.edtUsername)).getText().toString();
                String password = ((EditText)findViewById(R.id.edtPassword)).getText().toString();

                if(username.equalsIgnoreCase("codekul") && password.equalsIgnoreCase("codekul")){
                    //for checking errors and data
                    //Log.i("@codkul","username my " +username);

                    startActivity( new Intent(MainActivity.this,Dashboard.class));

                }
            }
        });

    }
}
