package com.example.myapplication.TD.td3;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.TextView;

public class MyReceiver extends BroadcastReceiver {

    TextView textView ;
    MyReceiver(TextView textView){
        this.textView = textView;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals("com.example.myapplication")) {
            String time = intent.getExtras().getString("time");
            textView.setText(time);
        }
    }
}