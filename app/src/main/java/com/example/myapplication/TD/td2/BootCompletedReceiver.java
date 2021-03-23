package com.example.myapplication.TD.td2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class BootCompletedReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if(action != null) {
            if (action.equals(Intent.ACTION_AIRPLANE_MODE_CHANGED) ) {
                Toast.makeText(context, "AIRPLANE MODE CHANGED !", Toast.LENGTH_SHORT).show();
            }
            if (action.equals(Intent.ACTION_BOOT_COMPLETED) ) {
                Toast.makeText(context, "BOOT COMPLETED", Toast.LENGTH_SHORT).show();
            }
            if (action.equals(Intent.ACTION_BATTERY_LOW) ) {
                Toast.makeText(context, "BATTERY LOW", Toast.LENGTH_SHORT).show();
            }
        }
    }
}