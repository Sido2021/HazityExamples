package com.example.myapplication.cours.threads.exemple1;

import android.util.Log;
import android.widget.ProgressBar;

class MyThread implements Runnable{
    ProgressBar bar ;
    public MyThread(ProgressBar bar){
        this.bar = bar ;
    }

    @Override
    public void run() {
        for(int i=0;i<= 10 ;i++){
            bar.setProgress(i);
            try {
                Thread.sleep(1000);
            }
            catch(InterruptedException ex){
                Log.e("error : ",ex.getMessage());
            }
        }
    }
}