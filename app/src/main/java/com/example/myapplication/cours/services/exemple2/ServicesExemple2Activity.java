package com.example.myapplication.cours.services.exemple2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.myapplication.R;

public class ServicesExemple2Activity extends AppCompatActivity {

    Button button ;
    TextView textView ;

    int counter = 0 ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_exemple2);

        textView = findViewById(R.id.text_view_service_exemple2);
        button = findViewById(R.id.button_start_service_exemple2);

        button.setOnClickListener(v -> {
            Intent intent = new Intent(ServicesExemple2Activity.this, IntentServiceExample.class);

            intent.putExtra("code",counter);
            counter++;
            textView.setText("counter : "+counter);
            IntentServiceExample.enqueueWork(this,intent);
        });
    }
}