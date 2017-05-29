package com.example.interactivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.TextView;

public class Profileactivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profileactivity);
        Intent responsibleintent=getIntent();
        Bundle bundle=responsibleintent.getExtras();

        if (bundle!=null)
        {
            String username=bundle.getString("KeyStr");
            ((TextView)findViewById(R.id.txt3)).setText(username);
        }

        findViewById(R.id.btnBack).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle=new Bundle();
                bundle.putString("KeySt",getDanceName());

                Intent intent1=new Intent();
                intent1.putExtras(bundle);
                setResult(RESULT_OK,intent1);
                finish();
            }
        });

    }
    private String getDanceName()
    {

        if( ((RadioGroup)findViewById(R.id.rgrp)).getCheckedRadioButtonId()==R.id.rb1)
            return "classical";
        else if(((RadioGroup)findViewById(R.id.rgrp)).getCheckedRadioButtonId()==R.id.rb2)
            return"Bollywood";
        else
            return "hip hop";

    }
}


