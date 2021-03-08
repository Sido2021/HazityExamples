package com.example.myapplication.cours.services.exemple1;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Toast;

public class IntentServiceExample extends Service {
    public IntentServiceExample() {
    }

    @Override
    public void onCreate() {
        Toast.makeText(this, "Service was created !", Toast.LENGTH_SHORT).show();
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(this, "Service started !", Toast.LENGTH_SHORT).show();
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "Service destroyed !", Toast.LENGTH_SHORT).show();
    }
}