package com.example.myapplication.TD.td4;

import android.graphics.Bitmap;

import androidx.annotation.NonNull;

import java.io.Serializable;
import java.sql.Date;

public class Person {
    int id ;
    String name;
    java.sql.Date birthdate ;
    Bitmap picture ;

    Person(String name , Date birthdate , Bitmap picture){
        this.name = name ;
        this.birthdate = birthdate;
        this.picture = picture;
    }
    Person(int id ,String name , Date birthdate , Bitmap picture){
        this.id = id;
        this.name = name ;
        this.birthdate = birthdate;
        this.picture = picture;
    }

    @NonNull
    @Override
    public String toString() {
        return name+" ("+id+")";
    }
}
