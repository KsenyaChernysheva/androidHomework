package com.example.xenya.homeworkapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
    private Button btn_back;
    private Button btn_cancel;
    private EditText et_name;
    private EditText et_phone;
    private EditText et_mail;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        btn_back = findViewById(R.id.btn_back);
        btn_cancel = findViewById(R.id.btn_cancel);
        et_name = findViewById(R.id.et_name);
        et_phone = findViewById(R.id.et_phone);
        et_mail = findViewById(R.id.et_email);

        Intent intent = getIntent();
        et_name.setText(intent.getStringExtra(MainActivity.KEY_NAME));
        et_phone.setText(intent.getStringExtra(MainActivity.KEY_PHONE));
        et_mail.setText(intent.getStringExtra(MainActivity.KEY_MAIL));

        btn_back.setOnClickListener(view -> {
            Intent perehod2 = new Intent();
            perehod2.putExtra(MainActivity.KEY_NAME,et_name.getText().toString());
            perehod2.putExtra(MainActivity.KEY_PHONE,et_phone.getText().toString());
            perehod2.putExtra(MainActivity.KEY_MAIL,et_mail.getText().toString());
            setResult(RESULT_OK,perehod2);
            finish();
        });

        btn_cancel.setOnClickListener(view -> {
            setResult(RESULT_CANCELED);
            finish();
        });
    }

}
