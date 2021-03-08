
package com.example.myapplication.cours.threads.exemple5;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.ProgressBar;

import com.example.myapplication.R;

public class Exemple5Activity extends AppCompatActivity {

    ProgressDialog progressDialog ;

    Handler handler = new Handler(Looper.myLooper()){
        @Override
        public void handleMessage(@NonNull Message msg) {
            int i = msg.what;
            if(i<6){
                progressDialog.setMessage("Thread " + i + " terminé ! ...");
                progressDialog.setProgress(i);
            }
            else progressDialog.dismiss();
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exemple5);

        progressDialog = new ProgressDialog(this);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progressDialog.setMessage("Chargement encours ... ");
        progressDialog.setTitle("Progress");
        progressDialog.setMax(5);
        progressDialog.show();

        Thread thread = new Thread(()->{
            try {
                for (int i = 1 ; i<=6 ;i++){
                    if(i<5)Thread.sleep(5000);
                    else Thread.sleep(500);
                    handler.sendEmptyMessage(i);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        thread.start();
    }
}