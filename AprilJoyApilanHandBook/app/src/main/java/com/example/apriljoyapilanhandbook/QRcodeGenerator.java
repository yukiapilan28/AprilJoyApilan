package com.example.apriljoyapilanhandbook;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

public class QRcodeGenerator extends AppCompatActivity {
    EditText fullname;
    EditText address;
    EditText contactnumber;
    ImageView qrcode;
    Button generate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_q_rcode_generator);

        fullname = findViewById(R.id.etxtName);
        address = findViewById(R.id.etxtAdd);
        contactnumber = findViewById(R.id.etxtCN);
        qrcode = findViewById(R.id.iviewQr);
        generate = findViewById(R.id.btnQR);

        generate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                QRCodeWriter qrCodeWriter = new QRCodeWriter();

                try {
                    BitMatrix bitMatrix = qrCodeWriter.encode(
                            fullname.getText().toString() + "\n" +
                                    address.getText().toString() + "\n" +
                                    contactnumber.getText().toString(),
                            BarcodeFormat.QR_CODE, 200, 200);

                    Bitmap bitmap = Bitmap.createBitmap(200, 200, Bitmap.Config.RGB_565);
                    for (int x = 0; x < 200; x++){
                        for (int y = 0; y < 200; y++){
                            bitmap.setPixel(x,y,bitMatrix.get(x,y) ? Color.BLACK: Color.WHITE);
                        }
                    }
                    qrcode.setImageBitmap(bitmap);

                } catch (WriterException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}