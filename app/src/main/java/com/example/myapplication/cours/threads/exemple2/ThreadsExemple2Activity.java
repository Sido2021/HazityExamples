//exemple taches lourdes

package com.example.myapplication.cours.threads.exemple2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.myapplication.R;

public class ThreadsExemple2Activity extends AppCompatActivity {
    TextView textView ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exemple2);

        textView = findViewById(R.id.text_view_thread_ex2);
    }

    public void onclick(View view){
        MyThread myThread = new MyThread();
        myThread.start();
        textView.setText(R.string.thread_traitement);
    }
}