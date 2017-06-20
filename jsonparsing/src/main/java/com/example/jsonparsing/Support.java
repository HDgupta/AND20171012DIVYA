package com.example.jsonparsing;

import android.content.Context;
import android.content.res.AssetManager;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by divya on 20/6/17.
 */

public class Support {

    public static String readAsset(Context context){
        StringBuffer buffer = new StringBuffer();
        AssetManager manager = context.getAssets();
        try {
            InputStream is = manager.open("our.json");
            while (true){
                int ch =is.read();
                if(ch==-1)break;
                else buffer.append((char) ch);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return buffer.toString();
    }
}
