package com.project.greenhat.citylog;

import android.app.FragmentManager;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class Cities extends android.app.Fragment {


    Button b1,b2,b3,b4,b5;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cities, container, false);
    }

    @Override
    public void onActivityCreated( Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        b1=(Button)getActivity().findViewById(R.id.cb1);
        b2=(Button)getActivity().findViewById(R.id.cb2);
        b3=(Button)getActivity().findViewById(R.id.cb3);
        b4=(Button)getActivity().findViewById(R.id.cb4);
        b5=(Button)getActivity().findViewById(R.id.cb5);
       // final FragmentManager f2=getFragmentManager();
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                FragmentManager f2=getFragmentManager();
                f2.beginTransaction().replace(R.id.home,new Perth()).commit();
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                FragmentManager f2=getFragmentManager();
                f2.beginTransaction().replace(R.id.home,new Brisbane()).commit();
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager f2=getFragmentManager();
                f2.beginTransaction().replace(R.id.home,new Sydney()).commit();
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager f2=getFragmentManager();

                f2.beginTransaction().replace(R.id.home,new Melbourne()).commit();
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager f2=getFragmentManager();

                f2.beginTransaction().replace(R.id.home,new Adelaide()).commit();
            }
        });

    }
}
