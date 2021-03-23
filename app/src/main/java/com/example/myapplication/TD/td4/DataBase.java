package com.example.myapplication.TD.td4;

import java.util.ArrayList;
import java.util.jar.Attributes;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase;

public class DataBase extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "DataBasePersons.db";
    public static final String TABLE_NAME = "person";
    public static final String CIN = "cin";
    public static final String NAME = "name";

    public DataBase(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(
                "create table "+TABLE_NAME +
                        " ("+CIN+" text primary key, "+NAME+" text)"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }

    public void insertPerson(Person p) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(CIN, p.cin);
        contentValues.put(NAME, p.name);
        db.insert(TABLE_NAME, null, contentValues);
    }

    public ArrayList<Person> getPersons() {
        ArrayList<Person> list = new ArrayList();

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from contacts", null );
        res.moveToFirst();

        while(res.isAfterLast() == false){
            String cin = res.getString(res.getColumnIndex(CIN));
            String name = res.getString(res.getColumnIndex(NAME));
            list.add(new Person(cin,name));
            res.moveToNext();
        }
        return list;
    }
}
