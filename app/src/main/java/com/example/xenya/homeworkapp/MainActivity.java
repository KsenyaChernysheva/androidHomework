package com.example.xenya.homeworkapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final String KEY_NAME = "NAME";
    public static final String KEY_PHONE = "PHONE";
    public static final String KEY_MAIL = "MAIL";

    private static final int EDIT_REQUEST_CODE = 0;
    private static final int SEND_REQUEST_CODE = 1;

    private Button btnUpdate;
    private Button btnSend;

    private TextView tName;
    private TextView tPhone;
    private TextView tMail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSend = findViewById(R.id.btn_send);
        btnUpdate = findViewById(R.id.btn_update);
        tName = findViewById(R.id.text_name);
        tPhone = findViewById(R.id.text_phone);
        tMail = findViewById(R.id.text_email);

        btnUpdate.setOnClickListener(v -> {
            Intent intentToSecondAct = new Intent(this, SecondActivity.class);
            intentToSecondAct.putExtra(KEY_NAME, tName.getText().toString());
            intentToSecondAct.putExtra(KEY_PHONE, tPhone.getText().toString());
            intentToSecondAct.putExtra(KEY_MAIL, tMail.getText().toString());
            startActivityForResult(intentToSecondAct, EDIT_REQUEST_CODE);
        });

        btnSend.setOnClickListener(view -> {
            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("text/plain");
            intent.putExtra(Intent.EXTRA_TEXT, tName.getText().toString() + tPhone.getText().toString() + tMail.getText().toString());
            startActivityForResult(intent, SEND_REQUEST_CODE);
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == EDIT_REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                if (data != null) {
                    tName.setText(data.getStringExtra(KEY_NAME));
                    tPhone.setText(data.getStringExtra(KEY_PHONE));
                    tMail.setText(data.getStringExtra(KEY_MAIL));
                }
            } else if (resultCode == RESULT_CANCELED) {
                Toast.makeText(this, "Canceled", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Smt wrong", Toast.LENGTH_SHORT).show();
            }
        } else if (requestCode == SEND_REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                Toast.makeText(this, "Sent", Toast.LENGTH_SHORT).show();
            } else if (resultCode == RESULT_CANCELED) {
                Toast.makeText(this, "Canceled", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Smt wrong", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
