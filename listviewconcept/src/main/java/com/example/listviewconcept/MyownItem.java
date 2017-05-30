package com.example.listviewconcept;

import android.content.Context;

/**
 * Created by divya on 29/5/17.
 */

public class MyownItem {

    public long itmid;
    public int imgid;
    public String text;

    public MyownItem(long itmid,int imgid,String text)
    {
        this.itmid=itmid;
        this.imgid=imgid;
        this.text=text;
    }
}
