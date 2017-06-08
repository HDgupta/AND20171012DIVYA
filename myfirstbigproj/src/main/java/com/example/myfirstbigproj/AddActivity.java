package com.example.myfirstbigproj;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class AddActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        ((Button)findViewById(R.id.btnSave)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                String newname = ((EditText)findViewById(R.id.nameAdd)).getText().toString();
//                String newage = ((EditText)findViewById(R.id.ageAdd)).getText().toString();
//
//                Bundle bundle = new Bundle();
//                bundle.putString("KeynewName",newname);
//                bundle.putString("KeynewAge",newage);
//
//                Intent intent = new Intent(AddActivity.this,Dashboard.class);
//                intent.putExtra("newname",newname);
//                intent.putExtra("newage", newage);
//                startActivityForResult(intent,1235);

                Player_list.dataset.add(new MyownItem( "New One", "12", R.mipmap.ic_launcher,""));

            }
        });
    }
}
