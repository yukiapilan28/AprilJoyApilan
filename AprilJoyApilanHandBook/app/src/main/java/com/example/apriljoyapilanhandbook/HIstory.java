package com.example.apriljoyapilanhandbook;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

public class HIstory extends AppCompatActivity {

    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_h_istory);
        textView=findViewById(R.id.textView5);
        textView.setMovementMethod(new ScrollingMovementMethod());
    }
}