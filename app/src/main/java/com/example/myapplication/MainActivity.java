package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.myapplication.TD.td1.TD1Activity;
import com.example.myapplication.TD.td3.Exercice3Activity;
import com.example.myapplication.cours.fragments.exemple1.MainActivityFragment;
import com.example.myapplication.cours.resources.exemple4.ResourcesExemple4Activity;
import com.example.myapplication.cours.resources.exemple1.ResourcesExemple1Activity;
import com.example.myapplication.cours.resources.exemple2.ResourcesExemple2Activity;
import com.example.myapplication.cours.resources.exemple3.ResourcesExemple3Activity;
import com.example.myapplication.cours.resources.exemple5.ResourcesExemple5Activity;
import com.example.myapplication.cours.resources.exemple6.ResourcesExemple6Activity;
import com.example.myapplication.cours.resources.exemple7.ResourcesExemple7Activity;
import com.example.myapplication.cours.resources.exemple8.MapsActivity;
import com.example.myapplication.cours.resources.exemple9.ResourcesExemple9Activity;
import com.example.myapplication.cours.services.exemple1.ServicesExemple1Activity;
import com.example.myapplication.cours.services.exemple2.ServicesExemple2Activity;
import com.example.myapplication.cours.services.exemple3.ServicesExemple3Activity;
import com.example.myapplication.cours.threads.exemple1.ThreadsExemple1Activity;
import com.example.myapplication.cours.threads.exemple2.ThreadsExemple2Activity;
import com.example.myapplication.cours.threads.exemple3.ThreadsExemple3Activity;
import com.example.myapplication.cours.threads.exemple4.ThreadsExemple4Activity;
import com.example.myapplication.cours.threads.exemple5.ThreadsExemple5Activity;
import com.example.myapplication.cours.threads.exemple6.ThreadsExemple6Activity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void onClick(View v) {
        if (v.getId() == R.id.button_thread_exemple1) {
            startNewActivity(ThreadsExemple1Activity.class);
        } else if (v.getId() == R.id.button_thread_exemple2) {
            startNewActivity(ThreadsExemple2Activity.class);
        } else if (v.getId() == R.id.button_thread_exemple3) {
        startNewActivity(ThreadsExemple3Activity.class);
        }
        else if (v.getId() == R.id.button_thread_exemple4) {
            startNewActivity(ThreadsExemple4Activity.class);
        }
        else if (v.getId() == R.id.button_thread_exemple5) {
            startNewActivity(ThreadsExemple5Activity.class);
        }
        else if (v.getId() == R.id.button_thread_exemple6) {
            startNewActivity(ThreadsExemple6Activity.class);
        }
        else if (v.getId() == R.id.button_service_exemple1) {
            startNewActivity(ServicesExemple1Activity.class);
        }
        else if (v.getId() == R.id.button_service_exemple2) {
            startNewActivity(ServicesExemple2Activity.class);
        }
        else if (v.getId() == R.id.button_service_exemple3) {
            startNewActivity(ServicesExemple3Activity.class);
        }
        else if (v.getId() == R.id.button_open_td1) {
            startNewActivity(TD1Activity.class);
        }
        else if (v.getId() == R.id.button_fragment_exemple1) {
            startNewActivity(MainActivityFragment.class);
        }
        else if (v.getId() == R.id.button_resource_exemple1) {
            startNewActivity(ResourcesExemple1Activity.class);
        }
        else if (v.getId() == R.id.button_resource_exemple2) {
            startNewActivity(ResourcesExemple2Activity.class);
        }
        else if (v.getId() == R.id.button_resource_exemple3) {
            startNewActivity(ResourcesExemple3Activity.class);
        }
        else if (v.getId() == R.id.button_resource_exemple4) {
            startNewActivity(ResourcesExemple4Activity.class);
        }
        else if (v.getId() == R.id.button_resource_exemple5) {
            startNewActivity(ResourcesExemple5Activity.class);
        }
        else if (v.getId() == R.id.button_resource_exemple6) {
            startNewActivity(ResourcesExemple6Activity.class);
        }
        else if (v.getId() == R.id.button_resource_exemple7) {
            startNewActivity(ResourcesExemple7Activity.class);
        }
        else if (v.getId() == R.id.button_resource_exemple8) {
            startNewActivity(MapsActivity.class);
        }
        else if (v.getId() == R.id.button_resource_exemple9) {
            startNewActivity(ResourcesExemple9Activity.class);
        }
        else if (v.getId() == R.id.button_open_td3) {
            startNewActivity(Exercice3Activity.class);
        }

    }

    private void startNewActivity(Class activity) {
        startActivity(new Intent(this,activity));
    }
}