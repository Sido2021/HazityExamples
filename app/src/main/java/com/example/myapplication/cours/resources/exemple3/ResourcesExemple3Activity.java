package com.example.myapplication.cours.resources.exemple3;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myapplication.R;

public class ResourcesExemple3Activity extends AppCompatActivity {
    Button play, stop;
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resource_exemple3);

        play = findViewById(R.id.button_play_resource_ex3);
        stop = findViewById(R.id.button_stop_resource_ex3);

        play.setOnClickListener(v -> {
            if(mediaPlayer != null && mediaPlayer.isPlaying())mediaPlayer.stop();

            mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.song1);
            mediaPlayer.start();
        });
        stop.setOnClickListener(v -> {
            if (mediaPlayer != null && mediaPlayer.isPlaying())
                mediaPlayer.stop();
        });
    }
}