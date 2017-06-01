package com.example.fragmentconcept;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class PanelFragment extends Fragment {


    public PanelFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View main =inflater.inflate(R.layout.fragment_panel, container, false);

        final MainActivity activity= (MainActivity) getActivity();

        main.findViewById(R.id.btnOne).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Bundle bundle=new Bundle();
                bundle.putInt(FirstFragment.Key_Num,R.drawable.ic_call_made_black_24dp);

                FirstFragment fragment=new FirstFragment();
                fragment.setArguments(bundle);

                activity.loadFragment(fragment);
            }
        });

        main.findViewById(R.id.btnTwo).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                activity.loadFragment(FirstFragment.getinstance(R.drawable.ic_call_missed_black_24dp));
            }
        });

        main.findViewById(R.id.btnThree).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                activity.loadFragment(FirstFragment.getinstance(R.drawable.ic_call_received_black_24dp));
            }
        });


        return main;
    }

}
