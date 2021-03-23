package com.example.myapplication.TD.td4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.myapplication.R;

public class TD4Activity extends AppCompatActivity {

    Button buttonAdd ;
    EditText editTextCin , editTextName ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_td_4);

        DataBase db = new DataBase(this);

        editTextCin = findViewById(R.id.edit_text_cin);
        editTextName = findViewById(R.id.edit_text_name);

        buttonAdd =findViewById(R.id.button_add);

        buttonAdd.setOnClickListener(v -> {
            String cin = editTextCin.getText().toString();
            String name = editTextName.getText().toString();
            Person p = new Person(cin,name);

            db.insertPerson(p);
        });

    }


}