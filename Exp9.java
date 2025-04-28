package com.vivssecure.family;

import android.annotation.SuppressLint;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MusicPlayer extends AppCompatActivity {

    MediaPlayer mediaPlayer;
    Button playBtn, pauseBtn, stopBtn;
    SeekBar seekBar;
    TextView songTitle;

    Handler handler = new Handler();
    Runnable updateSeekBar;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.music_player);

        playBtn = findViewById(R.id.playBtn);
        pauseBtn = findViewById(R.id.pauseBtn);
        stopBtn = findViewById(R.id.stopBtn);
        seekBar = findViewById(R.id.seekBar);
        songTitle = findViewById(R.id.songTitle);

        // Set song name
        songTitle.setText("Song: Camila Cabello - Señorita");

        mediaPlayer = MediaPlayer.create(this, R.raw.song);
        seekBar.setMax(mediaPlayer.getDuration());

        // Update SeekBar periodically
        updateSeekBar = new Runnable() {
            @Override
            public void run() {
                if (mediaPlayer != null && mediaPlayer.isPlaying()) {
                    seekBar.setProgress(mediaPlayer.getCurrentPosition());
                    handler.postDelayed(this, 500);
                }
            }
        };

        playBtn.setOnClickListener(v -> {
            if (!mediaPlayer.isPlaying()) {
                mediaPlayer.start();
                handler.post(updateSeekBar);
            }
        });

        pauseBtn.setOnClickListener(v -> {
            if (mediaPlayer.isPlaying()) {
                mediaPlayer.pause();
            }
        });

        stopBtn.setOnClickListener(v -> {
            if (mediaPlayer != null) {
                mediaPlayer.stop();
                mediaPlayer.release();
                mediaPlayer = MediaPlayer.create(this, R.raw.song);
                seekBar.setProgress(0);
            }
        });

        // SeekBar change by user
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            boolean userTouching = false;

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (fromUser && mediaPlayer != null) {
                    mediaPlayer.seekTo(progress);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                userTouching = true;
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                userTouching = false;
            }
        });
    }

    @Override
    protected void onDestroy() {
        handler.removeCallbacks(updateSeekBar);
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
        super.onDestroy();
    }
}

musicplayer.xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:gravity="center"
    android:orientation="vertical"
    android:padding="24dp">

    <TextView
        android:id="@+id/songTitle"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Song: Beautiful Melody"
        android:textSize="18sp"
        android:textStyle="bold"
        android:layout_marginBottom="20dp"/>

    <SeekBar
        android:id="@+id/seekBar"
        android:layout_width="match_parent"
        android:layout_height="wrap_content" />

    <LinearLayout
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:orientation="horizontal"
        android:layout_marginTop="24dp">

        <Button
            android:id="@+id/playBtn"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="Play" />

        <Button
            android:id="@+id/pauseBtn"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="Pause"
            android:layout_marginLeft="16dp" />

        <Button
            android:id="@+id/stopBtn"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="Stop"
            android:layout_marginLeft="16dp" />
    </LinearLayout>
</LinearLayout>