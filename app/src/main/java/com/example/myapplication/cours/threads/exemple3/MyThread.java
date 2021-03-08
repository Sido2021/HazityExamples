package com.example.myapplication.cours.threads.exemple3;

import android.widget.TextView;

import com.example.myapplication.R;

public class MyThread implements Runnable{
    TextView textView ;
    public MyThread(TextView textView){
        this.textView = textView;
    }
    @Override
    public void run() {
        textView.setText(R.string.click_thread);
    }
}
