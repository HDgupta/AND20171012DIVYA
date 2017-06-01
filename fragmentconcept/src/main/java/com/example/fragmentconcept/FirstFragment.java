package com.example.fragmentconcept;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


/**
 * A simple {@link Fragment} subclass.
 */
public class FirstFragment extends Fragment {

    public static final String Key_Num="frag";
    public FirstFragment() {
        // Required empty public constructor
    }

    public static FirstFragment getinstance(int img){

        Bundle bundle=new Bundle();
        bundle.putInt(Key_Num,img);

        FirstFragment fragment=new FirstFragment();
        fragment.setArguments(bundle);
        return  fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

       final View main=inflater.inflate(R.layout.fragment_first, container, false);

        Bundle bundle=getArguments();
        int img=bundle.getInt(Key_Num);

        ImageView image= (ImageView) main.findViewById(R.id.imageView);
        image.setImageResource(img);

        return main;    }

}
