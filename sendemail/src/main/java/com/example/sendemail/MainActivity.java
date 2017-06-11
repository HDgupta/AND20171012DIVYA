package com.example.sendemail;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void filterschange(View view) {

        Intent intent = null;
        Intent chooser = null;

        if (view.getId() == R.id.btnEmail) {

            intent = new Intent(Intent.ACTION_SEND);
            intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"dinesh.gupta11269@gmail.com"});
            intent.putExtra(Intent.EXTRA_SUBJECT, "normal app");
            intent.putExtra(Intent.EXTRA_TEXT, "what r u doing?");
            intent.setType("message/rfc822");
            chooser = Intent.createChooser(intent, "Send Email");
            startActivity(chooser);
        } else
        {
            intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("geo:20.014,30.2341"));
            chooser = Intent.createChooser(intent, "Launch Map");
            startActivity(chooser);
        }

    }
}
