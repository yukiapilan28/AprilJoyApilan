package com.example.apriljoyapilanhandbook;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;
public class VIdeo extends AppCompatActivity {
    VideoView STIVideo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_v_ideo);

        STIVideo = findViewById(R.id.videoView);
        STIVideo.setVideoPath("android.resource://" + getPackageName() + "/" + R.raw.stivideo);
        MediaController VideoControl = new MediaController(this);
        VideoControl.setAnchorView(STIVideo);
        STIVideo.setMediaController(VideoControl);
        STIVideo.start();
    }
}