package com.example.myapplication.cours.services.exemple1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.myapplication.R;

public class ServicesExemple1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_exemple1);
    }

    public void onClick(View view){
        if(view.getId() == R.id.button_start_service_exemple1){
            startService(new Intent(this,IntentServiceExample.class));
        }
        else if (view.getId() == R.id.button_stop_service_exemple1){
            stopService(new Intent(this,IntentServiceExample.class));
        }
    }
}