package com.example.myapplication.cours.resources.exemple1;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.widget.Toast;

import com.example.myapplication.R;

public class MyReceiver extends BroadcastReceiver {

    MediaPlayer mp;
    public void onReceive(Context context, Intent intent) {
        mp= MediaPlayer.create(context, R.raw.song1);
        mp.start();
        Toast.makeText(context, "Alarm....", Toast.LENGTH_LONG).show();
    }

}