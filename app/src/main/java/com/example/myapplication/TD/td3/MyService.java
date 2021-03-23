package com.example.myapplication.TD.td3;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.widget.CalendarView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.MainActivity;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class MyService extends Service {
    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Intent broadcastIntent = new Intent();
        broadcastIntent.setAction("com.example.myapplication");

        Timer timer = new Timer();

        TimerTask t = new TimerTask() {
            @Override
            public void run() {

                String hour = String.valueOf(Calendar.getInstance().get(Calendar.HOUR_OF_DAY));
                String minutes = String.valueOf(Calendar.getInstance().get(Calendar.MINUTE));
                String secondes = String.valueOf(Calendar.getInstance().get(Calendar.SECOND));

                broadcastIntent.putExtra("time", hour+":"+minutes+":"+secondes);
                sendBroadcast(broadcastIntent);
            }
        };

        timer.scheduleAtFixedRate(t,1000,1000);


        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}