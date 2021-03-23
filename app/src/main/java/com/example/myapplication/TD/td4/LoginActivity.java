package com.example.myapplication.TD.td4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.myapplication.R;

public class LoginActivity extends AppCompatActivity {

    EditText editTextUsername , editTextPassword ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editTextUsername = findViewById(R.id.edit_text_username);
        editTextPassword = findViewById(R.id.edit_text_password);
    }
    private void onclick(View v){
        if(editTextUsername.getText().toString().equals("Said")
                && editTextPassword.getText().toString().equals("Said")){
            startActivity(new Intent(this,TD4Activity.class));
        }
    }
}