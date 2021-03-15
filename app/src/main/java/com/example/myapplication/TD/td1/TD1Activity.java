package com.example.myapplication.TD.td1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.myapplication.R;

public class TD1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_td1);

        TextView textView = findViewById(R.id.text_view_td1);
        Button button  = findViewById(R.id.button_td1);
        ProgressBar bar = findViewById(R.id.bar_td1);
        EditText editText = findViewById(R.id.edit_text_td1);

        button.setOnClickListener(v -> {
            runOnUiThread(new MyThread(textView,bar,20));
        });
    }
}