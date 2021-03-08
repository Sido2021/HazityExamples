//exemple handler

package com.example.myapplication.cours.threads.exemple4;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.ProgressBar;

import com.example.myapplication.R;

public class Exemple4Activity extends AppCompatActivity {
    ProgressBar progressBar ;
    Handler handler = new Handler(Looper.myLooper()){
        @Override
        public void handleMessage(@NonNull Message msg) {
            progressBar.incrementProgressBy(5);
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exemple4);
        progressBar = findViewById(R.id.progress_bar_ex4);
    }

    @Override
    protected void onStart() {
        super.onStart();
        progressBar.setProgress(0);

        Thread background = new Thread(() -> {
            for (int i=0;i<20;i++){
                try {
                    Thread.sleep(1000);

                    Message message = handler.obtainMessage();

                    handler.sendMessage(message);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        background.start();
    }
}