package com.project.greenhat.citylog;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * Created by greenhat on 29/8/17.
 */

public class adapt extends BaseAdapter {

    Context c;
    int c1;
    String date[],contact[],invoice[],dest[];
    @Override
    public int getCount() {
        return contact.length;
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater l1=(LayoutInflater)c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view=l1.inflate(R.layout.logview,null);

        TextView v=(TextView)view.findViewById(R.id.t1);

        TextView v1=(TextView)view.findViewById(R.id.t2);

        TextView v2=(TextView)view.findViewById(R.id.t3);

        TextView v3=(TextView)view.findViewById(R.id.t4);
        TextView v4=(TextView)view.findViewById(R.id.inv);

        v.setText("from ");
        v1.setText(date[i]);
        v2.setText(invoice[i]);
        v4.setText(contact[i]);
        v3.setText(dest[i]);

        return view;
    }

    adapt(Context c,String[] date,String[] contact,String[] invoice,String[] dest){
        this.c=c;
        this.date=date;
        this.contact=contact;
        this.invoice=invoice;
        this.dest=dest;
    }
}
