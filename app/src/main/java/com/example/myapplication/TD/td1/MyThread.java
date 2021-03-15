package com.example.myapplication.TD.td1;

import android.os.Handler;
import android.util.Log;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.myapplication.R;

public class MyThread implements Runnable{
    TextView textView ;
    ProgressBar bar ;
    int nomber ;
    int count = 5;
    public MyThread(TextView textView ,ProgressBar bar , int nomber){
        this.textView = textView;
        this.bar= bar ;
        this.nomber = nomber ;
    }
    @Override
    public void run() {
        String primaries = "hello";
        /*for(int i=2;i< nomber ;i++){
            if(isPrimaryNomber(i)){
                int p = bar.getProgress() ;
                bar.setProgress(++p);
                primaries+= i+",";
                count++;
            }

        }*/

        Handler handler1 = new Handler();
        for (int a = 1; a<10;a++) {
            int c = a;
            handler1.postDelayed(new Runnable() {
                @Override
                public void run() {
                    bar.setProgress(c);
                }
            }, 1000);
        }

        textView.setText(primaries);

    }

    /*private boolean isPrimaryNomber(int n) {
        for(int j = 2;j < n;j++){
            if(nomber%j ==0 ){
                return false;
            }
        }
        return true ;
    }*/
}

