package com.example.interactivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btnLogin).setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {

                String username = ((EditText) findViewById(R.id.txt1)).getText().toString();
                String password = ((EditText) findViewById(R.id.txt2)).getText().toString();

                if (username.equalsIgnoreCase("dg")
                        && password.equalsIgnoreCase("dg")) {
                    Bundle bundle = new Bundle();
                    bundle.putString("KeyStr", username);

                    Intent intent = new Intent(MainActivity.this, Profileactivity.class);
                    intent.putExtras(bundle);
                    //startActivity(intent);

                    startActivityForResult(intent, 123);
                }

            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==123 && resultCode==RESULT_OK && data!=null)
        {
            Bundle bundle= data.getExtras();
            String res=bundle.getString("KeySt");
            ((TextView)findViewById(R.id.txt1)).setText(res);

        }

    }


}
