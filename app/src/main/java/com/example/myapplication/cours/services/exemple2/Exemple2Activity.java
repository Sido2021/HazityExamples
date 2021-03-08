package com.example.myapplication.cours.services.exemple2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.myapplication.R;
import com.example.myapplication.cours.services.exemple1.IntentServiceExample;

public class Exemple2Activity extends AppCompatActivity {

    Button button ;
    TextView textView ;

    int counter = 0 ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_exemple2);

        //textView = findViewById(R.id.text_view_services_ex2);
        //button = findViewById(R.id.button_services_ex2);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Exemple2Activity.this, IntentServiceExample.class);

                intent.putExtra("code",counter);
                counter++;
                textView.setText("counter : "+counter);
                startService(intent);
            }
        });
    }
}