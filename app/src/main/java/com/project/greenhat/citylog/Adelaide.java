package com.project.greenhat.citylog;

import android.app.FragmentManager;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


public class Adelaide extends android.app.Fragment implements AdapterView.OnItemSelectedListener{

    Button b1,b2,b3,b4,b5,b6;
    SQLiteDatabase db;
    Context c;
    String date,contact,invoice,dest;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_adelaide, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        b1=getActivity().findViewById(R.id.date4);
        b2=getActivity().findViewById(R.id.cb14);
        b3=getActivity().findViewById(R.id.cb24);
        b4=getActivity().findViewById(R.id.prev4);
        b5=getActivity().findViewById(R.id.next4);
        b6=getActivity().findViewById(R.id.home14);


        Spinner spinner = (Spinner) getActivity().findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(this);

        // Spinner Drop down elements
        ArrayList<String> categories = new ArrayList<String>();
        categories.add("Perth");
        categories.add("Brisbane");
        categories.add("Sydney");
        categories.add("melbourne");
        categories.add("Adelaide");

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(getActivity().getBaseContext(), android.R.layout.simple_spinner_item, categories);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinner.setAdapter(dataAdapter);

        final EditText e1=(EditText)getActivity().findViewById(R.id.num);
        final EditText e2=(EditText)getActivity().findViewById(R.id.num1);
        final TextView v1=(TextView)getActivity().findViewById(R.id.tve);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Date b=new Date();

                b1.setVisibility(View.GONE);
                v1.setText(b.toString());
                v1.setVisibility(View.VISIBLE);

            }
        });

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                FragmentManager f=getFragmentManager();
                f.beginTransaction().replace(R.id.home,new Melbourne()).commit();
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager f=getFragmentManager();
                f.beginTransaction().replace(R.id.home,new Perth()).commit();
            }
        });
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager f=getFragmentManager();
                f.beginTransaction().replace(R.id.home,new Cities()).commit();
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Bundle b= new Bundle();
                b.putString("pert","alda");
                b.putString("name","Adelaide");
                android.app.Fragment f1=new Listv();
                f1.setArguments(b);
                FragmentManager f=getFragmentManager();
                f.beginTransaction().replace(R.id.home,f1).commit();
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                database db1=new database(getActivity().getBaseContext(),"logstore",null,3);
                db=db1.getWritableDatabase();
                DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                Date date1 = new Date();
                date=dateFormat.format(date1);
                contact=e1.getText().toString();
                invoice=e2.getText().toString();


                if (contact.equals("") || invoice.equals("") || dest.equals("")) {
                    Toast.makeText(getActivity().getBaseContext(), "Enter Full Details", Toast.LENGTH_SHORT).show();
                } else {
                    ContentValues cr = new ContentValues();
                    cr.put("contact", contact);
                    cr.put("invoice", invoice);
                    cr.put("date", date);
                    cr.put("dest", dest);

                    long  l1 = db.insert("", null, cr);
                    if (l1 > 0) {

                        Toast.makeText(getActivity().getApplicationContext(), "Saved", Toast.LENGTH_LONG).show();

                    } else {
                        Toast.makeText(getActivity().getApplicationContext(), "invalid details", Toast.LENGTH_SHORT).show();
                    }
                }


            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        dest = adapterView.getItemAtPosition(i).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
