package com.example.myapplication.cours.services.exemple2;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.SystemClock;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.app.JobIntentService;

public class IntentServiceExample extends JobIntentService {
    static final int JOB_ID = 1000;

    static void enqueueWork(Context context, Intent work) {
        enqueueWork(context, IntentServiceExample.class, JOB_ID, work);
    }

    @Override
    protected void onHandleWork(@NonNull Intent intent) {

        toast("Executing work: ");
        //int code = intent.getIntExtra("code",-1);

        long i = 0 ;
        while(i < 1000L) i++;

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        toast("All work complete");
    }

    @SuppressWarnings("deprecation")
    final Handler mHandler = new Handler();

    // Helper for showing tests
    void toast(final CharSequence text) {
        mHandler.post(() -> Toast.makeText(IntentServiceExample.this, text, Toast.LENGTH_SHORT).show());
    }
}
