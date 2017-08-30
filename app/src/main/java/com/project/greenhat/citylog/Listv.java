package com.project.greenhat.citylog;

import android.app.FragmentManager;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;


public class Listv extends android.app.Fragment {


    SQLiteDatabase db;
    Context c;
    String date[],contact[],invoice[],dest[];
    String s="";
    String s1="";
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle b=this.getArguments();
        s=b.getString("pert");
        s1=b.getString("name");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_listv, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        final ListView l1=(ListView)getActivity().findViewById(R.id.lt4);
        Button b=(Button)getActivity().findViewById(R.id.tr);
        b.setText("back to"+" "+s1);
        TextView v1=(TextView)getActivity().findViewById(R.id.t1);
       // v1.setText(s1);

        b.setOnClickListener(new View.OnClickListener() {
            FragmentManager f1=getFragmentManager();
            @Override
            public void onClick(View view) {

                switch (s1){

                    case "Perth":

                        f1.beginTransaction().replace(R.id.home,new Perth()).commit();
                        break;
                    case "Brisbane":
                       // FragmentManager f1=getFragmentManager();
                        f1.beginTransaction().replace(R.id.home,new Brisbane()).commit();
                        break;
                    case "sydney":
                        //FragmentManager f1=getFragmentManager();
                        f1.beginTransaction().replace(R.id.home,new Sydney()).commit();
                        break;
                    case "Melbourne":
                        //FragmentManager f1=getFragmentManager();
                        f1.beginTransaction().replace(R.id.home,new Melbourne()).commit();
                        break;
                    case "Adelaide":
                        //FragmentManager f1=getFragmentManager();
                        f1.beginTransaction().replace(R.id.home,new Adelaide()).commit();
                        break;
                }
            }
        });
        database db1=new database(getActivity().getBaseContext(),"logstore",null,3);
        db=db1.getWritableDatabase();
        Cursor c=null;
        c=db.rawQuery("select * from '"+s+"'",null);
        int x=c.getCount();
        date=new String[x];
        contact=new String[x];
        invoice=new String[x];

        dest=new String[x];
        int d=0;
        if(c.moveToFirst()) {
            do {
                contact[d] = c.getString(0);
                invoice[d] = c.getString(1);
                date[d]=c.getString(2);
                dest[d]=c.getString(3);
                d++;
            }
            while (c.moveToNext());
        }
        adapt c8= new adapt(getActivity().getBaseContext(),date,contact,invoice,dest);
        l1.setAdapter(c8);
    }
}
