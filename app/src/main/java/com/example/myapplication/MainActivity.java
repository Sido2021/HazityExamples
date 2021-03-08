package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myapplication.cours.threads.exemple1.Exemple1Activity;
import com.example.myapplication.cours.threads.exemple2.Exemple2Activity;
import com.example.myapplication.cours.threads.exemple3.Exemple3Activity;
import com.example.myapplication.cours.threads.exemple4.Exemple4Activity;
import com.example.myapplication.cours.threads.exemple5.Exemple5Activity;
import com.example.myapplication.cours.threads.exemple6.Exemple6Activity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void onClick(View v) {
        if (v.getId() == R.id.button_thread_exemple1) {
            startNewActivity(Exemple1Activity.class);
        } else if (v.getId() == R.id.button_thread_exemple2) {
            startNewActivity(Exemple2Activity.class);
        } else if (v.getId() == R.id.button_thread_exemple3) {
        startNewActivity(Exemple3Activity.class);
        }
        else if (v.getId() == R.id.button_thread_exemple4) {
            startNewActivity(Exemple4Activity.class);
        }
        else if (v.getId() == R.id.button_thread_exemple5) {
            startNewActivity(Exemple5Activity.class);
        }
        else if (v.getId() == R.id.button_thread_exemple6) {
            startNewActivity(Exemple6Activity.class);
        }
        else if (v.getId() == R.id.button_service_exemple1) {
            startNewActivity(com.example.myapplication.cours.services.exemple1.Exemple1Activity.class);
        }
    }

    private void startNewActivity(Class activity) {
        startActivity(new Intent(this,activity));
    }
}