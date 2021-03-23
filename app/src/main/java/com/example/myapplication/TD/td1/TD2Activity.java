package com.example.myapplication.TD.td1;


import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.myapplication.R;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

public class TD2Activity extends AppCompatActivity {

    ProgressBar progressBar;
    Button button ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_td2);

        progressBar = findViewById(R.id.progress_td2);
        button =findViewById(R.id.button_td2);

        MyTask myTask = new MyTask();
        myTask.execute();

        button.setOnClickListener(v -> myTask.cancel(true));
    }

    public class MyTask extends AsyncTask<String,Long,Void> {

        @Override
        protected void onPreExecute() {
            Toast.makeText(TD2Activity.this, "Lancement de la tache !", Toast.LENGTH_SHORT).show();
        }

        @Override
        protected void onProgressUpdate(Long... values) {
            progressBar.setProgress(values[0].intValue());
        }

        protected Void doInBackground(String...f_url) {

            int count;
            try {
                String root = Environment.getExternalStorageDirectory().toString();

                System.out.println("Downloading");
                URL url = new URL(f_url[0]);

                URLConnection conection = url.openConnection();
                conection.connect();
                // getting file length
                int lenghtOfFile = conection.getContentLength();

                // input stream to read file - with 8k buffer
                InputStream input = new BufferedInputStream(url.openStream(), 8192);

                // Output stream to write file

                OutputStream output = new FileOutputStream(root+"/downloadedfile.jpg");
                byte data[] = new byte[1024];

                long total = 0;
                while ((count = input.read(data)) != -1) {
                    if(isCancelled()) break;
                    total += count;
                    // writing data to file
                    output.write(data, 0, count);

                }

                // flushing output
                output.flush();

                // closing streams
                output.close();
                input.close();

            } catch (Exception e) {
                Log.e("Error: ", e.getMessage());
            }


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
            Toast.makeText(TD2Activity.this, "Le traitement est maintenant terminé !", Toast.LENGTH_SHORT).show();
        }

        @Override
        protected void onCancelled() {
            Toast.makeText(TD2Activity.this, "Le traitement est abandonné !", Toast.LENGTH_SHORT).show();
        }
    }
}