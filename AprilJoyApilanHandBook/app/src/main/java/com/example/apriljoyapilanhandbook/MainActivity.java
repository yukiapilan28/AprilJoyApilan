package com.example.apriljoyapilanhandbook;


import androidx.appcompat.app.AppCompatActivity;
        import android.content.Intent;
        import android.os.Bundle;
        import android.text.Editable;
        import android.text.TextWatcher;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.Toast;
        import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    Button btn_GoToHome, btn_Sign_Up;
    EditText etxt_UserName, etxt_Password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_GoToHome = findViewById(R.id.btnGoToHome);
        btn_Sign_Up = findViewById(R.id.btnSignUp);
        etxt_UserName = findViewById(R.id.etxtMUserName);
        etxt_Password = findViewById(R.id.etxtMPassword);
        final String FName = getIntent().getStringExtra("FName");
        final String UserName_txt = getIntent().getStringExtra("UName");
        final String Password_txt = getIntent().getStringExtra("Pass");
        etxt_UserName.addTextChangedListener(loginWacther);
        etxt_Password.addTextChangedListener(loginWacther);

        btn_GoToHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ((etxt_UserName.getText().toString().equals(UserName_txt)&& etxt_Password.getText().toString().equals(Password_txt)))
                {

                    Intent intentToGoHome = new Intent(MainActivity.this, Home.class);
                    intentToGoHome.putExtra("newname",FName);
                    startActivity(intentToGoHome);
                }
                else
                {
                    Toast.makeText(MainActivity.this, "Incorrect UserName or Password", Toast.LENGTH_SHORT).show();
                    etxt_UserName.getText().clear();
                    etxt_Password.getText().clear();
                }
            }
        });

        btn_Sign_Up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentSignUp = new Intent(MainActivity.this, SignUp.class);
                startActivity(intentSignUp);
            }
        });
    }
    private TextWatcher loginWacther = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            String UserName = etxt_UserName.getText().toString();
            String Password = etxt_Password.getText().toString();
            btn_GoToHome.setEnabled(!UserName.isEmpty() && !Password.isEmpty());
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };
}