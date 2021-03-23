package com.example.myapplication.TD.td4;

import androidx.annotation.NonNull;

import java.io.Serializable;

public class Person implements Serializable {
    String cin ;
    String name;

    Person(String cin ,String name){
        this.cin = cin;
        this.name = name ;
    }

    @NonNull
    @Override
    public String toString() {
        return name+" ("+cin+")";
    }
}
