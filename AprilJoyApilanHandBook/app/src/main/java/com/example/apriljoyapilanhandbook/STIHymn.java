package com.example.apriljoyapilanhandbook;
import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
public class STIHymn extends AppCompatActivity {

    Button Playbtn, Pausebtn, Stopbtn;
    MediaPlayer sti_hym = null;
    int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_s_t_i_hymn);

        Playbtn = findViewById(R.id.btnPlay);
        Pausebtn = findViewById(R.id.btnPause);
        Stopbtn = findViewById(R.id.btnStop);



        Playbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (sti_hym==null)
                {
                    sti_hym = MediaPlayer.create(getApplicationContext(),R.raw.stihymn);
                    sti_hym.start();
                }
                else if (!sti_hym.isPlaying()) {
                    sti_hym.seekTo(position);
                    sti_hym.start();
                }
            }
        });

        Pausebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (sti_hym!=null)
                {
                    sti_hym.pause();
                    position=sti_hym.getCurrentPosition();
                }
            }
        });

        Stopbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (sti_hym!=null)
                {
                    sti_hym.stop();
                    sti_hym=null;
                }
            }
        });
    }
    @Override
    protected void onStop() {
        super.onStop();
        sti_hym.stop();
        sti_hym=null;
    }
}