//exemple creation d'une thread

package com.example.myapplication.cours.threads.exemple1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import com.example.myapplication.R;

public class ThreadsExemple1Activity extends AppCompatActivity {
    ProgressBar bar ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exemple1);

        bar = findViewById(R.id.bar_ex1);
    }

    public void onclick(View view){
        bar.setProgress(0);
        MyThread myThread = new MyThread(bar);
        Thread thread = new Thread(myThread);
        thread.start();
    }
}