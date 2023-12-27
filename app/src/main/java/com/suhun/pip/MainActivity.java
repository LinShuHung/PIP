package com.suhun.pip;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    private String tag = MainActivity.class.getSimpleName();
    private FrameLayout counterFrame;
    private TextView counterView;
    private VideoView videoView;
    private Timer timer;
    private int counter;
    private UIHandler uiHandler;

    private class UIHandler extends Handler{
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            if(msg.what==0){
                counterView.setText(""+counter);
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initCounter();
        initVideoPlay();
    }

    private void initView(){
        counterFrame = findViewById(R.id.lid_counterFrame);
        counterView = findViewById(R.id.lid_counterView);
        videoView = findViewById(R.id.lid_videoView);
    }

    private void initCounter(){
        timer = new Timer();
        uiHandler = new UIHandler();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                counter++;
                uiHandler.sendEmptyMessage(0);

            }
        }, 0, 1000);
    }
    private void initVideoPlay(){
        //set media controller start
        MediaController mediaController = new MediaController(this);
        mediaController.setAnchorView(videoView);
        videoView.setMediaController(mediaController);
        //set media controller end
        String path = "android.resource://" + getPackageName() + "/" + R.raw.test12345;
        videoView.setVideoURI(Uri.parse(path));
        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                mediaPlayer.setLooping(true);
                mediaPlayer.start();
            }
        });
        counterFrame.setVisibility(View.GONE);
    }
}