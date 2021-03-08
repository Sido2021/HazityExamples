// exemple thread agir en inerface grafique

package com.example.myapplication.cours.threads.exemple3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.myapplication.R;

public class Exemple3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exemple3);
        TextView textView = findViewById(R.id.text_view_thread_ex3);
        Button button  = findViewById(R.id.button_thread_exemple3);

        button.setOnClickListener(v -> {
            //error : Only the original thread that created a view hierarchy can touch its views.
            new Thread(new MyThread(textView)).start();
        });

        button.setOnLongClickListener(v -> {
            //solve error
            runOnUiThread(new MyThread(textView));
            return true;
        });
    }
}