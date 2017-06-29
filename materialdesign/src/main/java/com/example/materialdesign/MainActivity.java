package com.example.materialdesign;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.ContextMenu;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String cut;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        registerForContextMenu(findViewById(R.id.eUsername));
        registerForContextMenu(findViewById(R.id.ePassword));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action ba if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Toast.makeText(this,"Settings",Toast.LENGTH_SHORT).show();
        }
        else if(id == R.id.signout)
            Toast.makeText(this,"Sign out successfully",Toast.LENGTH_SHORT).show();

        else if(id == R.id.acon) {
            Toast.makeText(this, "Profile changed", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(this, ProActivity.class));
        }

        else
            Toast.makeText(this,"Liked",Toast.LENGTH_SHORT).show();

        return super.onOptionsItemSelected(item);

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        if(v.getId() == R.id.eUsername){
            menu.add(100,1,0,"Cut");
            menu.add(100,2,1,"Copy");
        }
        else if(v.getId() == R.id.ePassword)
            menu.add(101,1,0,"Paste");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        if(item.getGroupId() == 100){

            if(item.getItemId() == 1) {

                cut = ((EditText)findViewById(R.id.eUsername)).getText().toString();
                ((EditText) findViewById(R.id.eUsername)).setText("");
                Toast.makeText(this, "Cut", Toast.LENGTH_SHORT).show();
            }
            else
                ((EditText)findViewById(R.id.eUsername)).setText(cut);
                Toast.makeText(this, "Copied", Toast.LENGTH_SHORT).show();
        }

        else if(item.getGroupId() == 101){

            if(item.getItemId() == 1){
                ((EditText)findViewById(R.id.ePassword)).setText(cut);
            }
        }

        return true;
    }
}
