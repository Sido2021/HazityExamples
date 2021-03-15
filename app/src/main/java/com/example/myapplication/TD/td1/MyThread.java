package com.example.myapplication.TD.td1;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.myapplication.R;

public class MyThread implements Runnable{
    TextView textView ;
    ProgressBar bar ;
    int nomber ;
    int count = 5;

    Handler handler = new Handler(Looper.myLooper()){
        @Override
        public void handleMessage(@NonNull Message msg) {
            int i = msg.what;
            int p = bar.getProgress() ;
            bar.setProgress(++p);
        }
    };

    public MyThread(TextView textView ,ProgressBar bar , int nomber){
        this.textView = textView;
        this.bar= bar ;
        this.nomber = nomber ;
    }
    @Override
    public void run() {
        String primaries = "hello";
        for(int i=2;i< nomber ;i++){
            if(isPrimaryNomber(i)){
                primaries+= i+",";
                handler.sendEmptyMessage(0);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        textView.setText(primaries);

    }

    private boolean isPrimaryNomber(int n) {
        for(int j = 2;j < n;j++){
            if(n%j ==0 ){
                return false;
            }
        }
        return true ;
    }
}

