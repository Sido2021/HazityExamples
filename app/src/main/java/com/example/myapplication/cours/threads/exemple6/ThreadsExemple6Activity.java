package com.example.myapplication.cours.threads.exemple6;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.myapplication.R;

public class ThreadsExemple6Activity extends AppCompatActivity {

    ProgressBar progressBar;
    Button button ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exemple6);

        progressBar = findViewById(R.id.progress_bar_threads_ex6);
        button =findViewById(R.id.button_threads_ex6);

        MyTask myTask = new MyTask();
        myTask.execute();

        button.setOnClickListener(v -> myTask.cancel(true));
    }

    public class MyTask extends AsyncTask<Void,Long,Void> {

        @Override
        protected void onPreExecute() {
            Toast.makeText(ThreadsExemple6Activity.this, "Lancement de la tache !", Toast.LENGTH_SHORT).show();
        }

        @Override
        protected void onProgressUpdate(Long... values) {
            progressBar.setProgress(values[0].intValue());
        }

        protected Void doInBackground(Void... params) {
            long progress ;
            for (progress = 0 ; progress<=100;progress++){
                if(isCancelled()) break;

                try {
                    publishProgress(progress);
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            Toast.makeText(ThreadsExemple6Activity.this, "Le traitement est maintenant terminé !", Toast.LENGTH_SHORT).show();
        }

        @Override
        protected void onCancelled() {
            Toast.makeText(ThreadsExemple6Activity.this, "Le traitement est abandonné !", Toast.LENGTH_SHORT).show();
        }
    }
}