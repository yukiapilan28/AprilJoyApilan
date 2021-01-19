package com.example.apriljoyapilanhandbook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SignUp extends AppCompatActivity {


    Button btnComplete;
    EditText FullNameetxt, UserNameetxt, Passwordetxt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        btnComplete = findViewById(R.id.btnComSugnUp);
        FullNameetxt = findViewById(R.id.etxtFullName);
        UserNameetxt = findViewById(R.id.etxtUserName);
        Passwordetxt = findViewById(R.id.etxtPassword);
        FullNameetxt.addTextChangedListener(SignUpWacther);
        UserNameetxt.addTextChangedListener(SignUpWacther);
        Passwordetxt.addTextChangedListener(SignUpWacther);

        btnComplete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String FullName = FullNameetxt.getText().toString();
                String UserName = UserNameetxt.getText().toString();
                String Password = Passwordetxt.getText().toString();

                Intent IntentComplete = new Intent(SignUp.this, MainActivity.class);
                IntentComplete.putExtra("FName",FullName);
                IntentComplete.putExtra("UName",UserName);
                IntentComplete.putExtra("Pass",Password);
                startActivity(IntentComplete);

            }
        });
    }
    private TextWatcher SignUpWacther = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            String FullName = FullNameetxt.getText().toString();
            String UserN = UserNameetxt.getText().toString();
            String Pass = Passwordetxt.getText().toString();
            btnComplete.setEnabled(!FullName.isEmpty() && !UserN.isEmpty() && !Pass.isEmpty());
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };
}