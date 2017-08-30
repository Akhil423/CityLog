package com.project.greenhat.citylog;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by greenhat on 29/8/17.
 */

public class database extends SQLiteOpenHelper {
    public database(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
    sqLiteDatabase.execSQL("create table if not exists perth(contact TEXT,invoice TEXT,date TEXT,dest TEXT);");
        sqLiteDatabase.execSQL("create table if not exists bris(contact TEXT,invoice TEXT,date TEXT,dest TEXT);");
        sqLiteDatabase.execSQL("create table if not exists syd(contact TEXT,invoice TEXT,date TEXT,dest TEXT);");
        sqLiteDatabase.execSQL("create table if not exists melb(contact TEXT,invoice TEXT,date TEXT,dest TEXT);");
        sqLiteDatabase.execSQL("create table if not exists alda(contact TEXT,invoice TEXT,date TEXT,dest TEXT);");


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
