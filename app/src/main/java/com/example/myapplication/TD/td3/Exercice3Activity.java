package com.example.myapplication.TD.td3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.myapplication.R;

public class Exercice3Activity extends AppCompatActivity {

    IntentFilter mIntentFilter ;

    MyReceiver myReceiver ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercice3);

        TextView textView = findViewById(R.id.text_view_exercice3);
        Button button = findViewById(R.id.button_exercice3);

        mIntentFilter = new IntentFilter();
        mIntentFilter.addAction("com.example.myapplication");

        myReceiver = new MyReceiver(textView);


        button.setOnClickListener((v)->{
            startService(new Intent(this,MyService.class));
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        registerReceiver(myReceiver,mIntentFilter);
    }
}