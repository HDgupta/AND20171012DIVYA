package com.example.notificationdialogs;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

/**
 * Created by divya on 5/6/17.
 */

public class ApplDialog extends DialogFragment {


    public static final String TAG_AIRPLANE_MODE="airplanemodeon";
    public static final String TAG_SHOW_CALENDAR="calendar";
    public static final String TAG_SHOW_TIME="time";
    public static final String TAG_SHOW_PROGRESS="progress";
    public static final String TAG_CUSTOM="custom";


    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        Dialog dialog = null;

        if(getTag().equals(TAG_AIRPLANE_MODE))
            dialog=airplaneModeon();
        else if(getTag().equals(TAG_SHOW_CALENDAR))
            dialog=showCalendar();
        else if(getTag().equals(TAG_SHOW_TIME))
            dialog=showTime();
        else if (getTag().equals(TAG_SHOW_PROGRESS))
            dialog=showProgress();
        else
            dialog=showCustom();


        return dialog;
    }

    public Dialog airplaneModeon(){

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setIcon(R.drawable.ic_airplanemode_active_black_24dp);
        builder.setTitle("Airplane mode");
        builder.setMessage("AIRPLANE MODE ON");
        builder.setPositiveButton("POSITIVE", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                 mt("positive");
            }
        });

        builder.setNegativeButton("NEGATIVE", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                mt("negative");
            }
        });

        AlertDialog dialog=builder.create();

        return dialog;
    }

    public Dialog showCalendar(){

        DatePickerDialog dialog = new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                mt("" + dayOfMonth + "-" + (month+1) + "-" + year);
            }
        },2017,6,5);
        return dialog;
    }

    public Dialog showTime(){

        TimePickerDialog dialog=new TimePickerDialog(getActivity(), new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                mt("" + hourOfDay + "." + minute);
            }
        },11,60,false);

        return dialog;
    }

    public Dialog showProgress(){

        ProgressDialog dialog=new ProgressDialog(getActivity());
        dialog.setTitle("Progress");
        dialog.setIcon(R.drawable.ic_sentiment_dissatisfied_black_24dp);
        dialog.setMessage("Loading..");
        dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
//        dialog.setMax(100);
//        dialog.setProgress(20);
        return dialog;
    }

    public Dialog showCustom(){

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        AlertDialog dialog=builder.create();

        LayoutInflater inflater=LayoutInflater.from(getActivity());
        View view=inflater.inflate(R.layout.custom_view,null,false);

        dialog.setView(view);

        return dialog ;
    }

    private void mt(String msg){

        Toast.makeText(getActivity(),msg,Toast.LENGTH_SHORT).show();
    }
}
