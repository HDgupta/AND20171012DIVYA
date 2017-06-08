package com.example.myfirstbigproj;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class DetailedInfo extends AppCompatActivity {

    private LayoutInflater inflater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed_info);


        findViewById(R.id.imgFav).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(findViewById(R.id.imgFav).getTag().equals("border")){
                    ((ImageView) findViewById(R.id.imgFav)).setImageResource(R.drawable.ic_favorite_black_24dp);
                    findViewById(R.id.imgFav).setTag("filled");
                }
                else
                    ((ImageView) findViewById(R.id.imgFav)).setImageResource(R.drawable.ic_favorite_border_black_24dp);
                findViewById(R.id.imgFav).setTag("border");
            }
        });


//        Intent responsibleintent = getIntent();
//        Bundle bundle = responsibleintent.getExtras();
//
//
//        if(bundle!=null){
//            String name = bundle.getString("KeyName");
//            ((TextView)findViewById(R.id.txtName1)).setText(name);
//
//            String age = bundle.getString("KeyAge");
//            ((TextView)findViewById(R.id.txtAge1)).setText(age);
//        }

        ((Button)findViewById(R.id.btnAdd)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(DetailedInfo.this,AddActivity.class));
                finish();
            }
        });
    }



//    public void changeColor(View view){
//       ImageButton btn = (ImageButton)findViewById(R.id.imgColour);
//        btn.setColorFilter(Color.argb(255, 255, 0 , 0));
//    }
}
