package com.suhun.pip;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {
    private String tag = MainActivity.class.getSimpleName();
    private FrameLayout counterFrame;
    private TextView counterView;
    private VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView(){
        counterFrame = findViewById(R.id.lid_counterFrame);
        counterView = findViewById(R.id.lid_counterView);
        videoView = findViewById(R.id.lid_videoView);
    }
}