package com.example.myapplication.TD.td4;

import java.io.ByteArrayOutputStream;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.google.android.material.tabs.TabLayout;

public class DataBase extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "DataBasePersons.db";
    public static final String TABLE_NAME = "person";
    public static final String ID = "id";
    public static final String NAME = "name";
    public static final String BIRTHDATE = "birthdate";
    public static final String PICTURE = "picture";

    public DataBase(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(
                "create table "+TABLE_NAME +
                        " ("+ID+" Integer primary key autoincrement, "+NAME+" text , "+BIRTHDATE+" date , "+PICTURE+" blob)"
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
        contentValues.put(NAME, p.name);
        contentValues.put(BIRTHDATE, p.birthdate.toString());
        contentValues.put(PICTURE, getBytes(p.picture));

        db.insert(TABLE_NAME, null, contentValues);
    }

    public Person getPerson(int personId) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery("select * from " + TABLE_NAME + " where " + ID + "=" + personId , null);

        res.moveToFirst();
        int id = res.getInt(res.getColumnIndex(ID));
        String name = res.getString(res.getColumnIndex(NAME));
        Date birthdate = Date.valueOf(res.getString(res.getColumnIndex(BIRTHDATE)));
        Bitmap picture = getImage(res.getBlob(res.getColumnIndex(PICTURE)));

        return new Person(id,name,birthdate,picture);
    }

    public ArrayList<Person> getPersons() {
        ArrayList<Person> list = new ArrayList<>();

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from "+TABLE_NAME, null );
        res.moveToFirst();

        while(res.isAfterLast() == false){
            int id = res.getInt(res.getColumnIndex(ID));
            String name = res.getString(res.getColumnIndex(NAME));
            Date birthdate = Date.valueOf(res.getString(res.getColumnIndex(BIRTHDATE)));
            Bitmap picture = getImage(res.getBlob(res.getColumnIndex(PICTURE)));

            list.add(new Person(id,name,birthdate,picture));
            res.moveToNext();
        }
        return list;
    }

    public void updatePerson(Person p) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(NAME, p.name);
        contentValues.put(BIRTHDATE, p.birthdate.toString());
        contentValues.put(PICTURE, getBytes(p.picture));

        db.update(TABLE_NAME, contentValues, ID+" = ? ", new String[] { Integer.toString(p.id) } );

    }

    public void deletePerson (int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME,
                ID+" = ? ",
                new String[] { Integer.toString(id)});
    }

    public byte[] getBytes(Bitmap bitmap) {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 0, stream);
        return stream.toByteArray();
    }


    public Bitmap getImage(byte[] image) {
        return BitmapFactory.decodeByteArray(image, 0, image.length);
    }
}
