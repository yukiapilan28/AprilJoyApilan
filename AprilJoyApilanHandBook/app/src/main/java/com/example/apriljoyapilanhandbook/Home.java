package com.example.apriljoyapilanhandbook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class Home extends AppCompatActivity {

    ImageButton CalcuIbtn, HistoryIbtn, HimnIBtn, WebIbtn, VideoIbtn, QRCGbtn;
    TextView Nametxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        QRCGbtn = findViewById(R.id.ibtnQRCG);
        CalcuIbtn = findViewById(R.id.ibtnCalcu);
        HistoryIbtn = findViewById(R.id.ibtnHistory);
        HimnIBtn = findViewById(R.id.ibtnSTIHimn);
        Nametxt = findViewById(R.id.txtName);
        WebIbtn = findViewById(R.id.ibtnWebsite);
        VideoIbtn = findViewById(R.id.ibtnVideo);
        String Name = getIntent().getStringExtra("newname");
        Nametxt.setText(Name);

        CalcuIbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentCalcu = new Intent (Home.this, GradeCalculator.class);
                startActivity(intentCalcu);
            }
        });

        HistoryIbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intenthistory = new Intent (Home.this, HIstory.class);
                startActivity(intenthistory);
            }
        });

        HimnIBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intenthistory = new Intent (Home.this, STIHymn.class);
                startActivity(intenthistory);
            }
        });
        WebIbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://www.sti.edu/";
                Intent intentWebsite = new Intent(Intent.ACTION_VIEW);
                intentWebsite.setData(Uri.parse(url));
                startActivity(intentWebsite);
            }
        });
        VideoIbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentvideo = new Intent (Home   .this, VIdeo.class);
                startActivity(intentvideo);
            }
        });
        QRCGbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentqrcg = new Intent(Home.this, QRcodeGenerator.class);
                startActivity(intentqrcg);
            }
        });
    }
}