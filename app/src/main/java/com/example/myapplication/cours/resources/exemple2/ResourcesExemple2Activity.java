//VideoView
package com.example.myapplication.cours.resources.exemple2;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;
import com.example.myapplication.cours.resources.exemple1.MyReceiver;

public class ResourcesExemple2Activity extends AppCompatActivity {

    VideoView videoView ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resource_exemple2);
        videoView = findViewById(R.id.video_view);
    }

    public void startVideo(View v) {
        String path = "android.resource://"+getPackageName()+"/"+R.raw.video1;
        Uri uri = Uri.parse(path);
        videoView.setVideoURI(uri);
        //videoView.setVideoPath ("http://www.site/movie.mp4");

        videoView.start();
    }
}