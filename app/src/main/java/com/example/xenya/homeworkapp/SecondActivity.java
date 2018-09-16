package com.example.xenya.homeworkapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
    private Button btnBack;
    private Button btnCancel;
    private EditText etName;
    private EditText etPhone;
    private EditText etMail;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        btnBack = findViewById(R.id.btnBack);
        btnCancel = findViewById(R.id.btnCancel);
        etName = findViewById(R.id.etName);
        etPhone = findViewById(R.id.etPhone);
        etMail = findViewById(R.id.etEmail);

        Intent intent = getIntent();
        etName.setText(intent.getStringExtra(MainActivity.KEY_NAME));
        etPhone.setText(intent.getStringExtra(MainActivity.KEY_PHONE));
        etMail.setText(intent.getStringExtra(MainActivity.KEY_MAIL));

        btnBack.setOnClickListener(view -> {
            Intent perehod2 = new Intent();
            perehod2.putExtra(MainActivity.KEY_NAME, etName.getText().toString());
            perehod2.putExtra(MainActivity.KEY_PHONE, etPhone.getText().toString());
            perehod2.putExtra(MainActivity.KEY_MAIL, etMail.getText().toString());
            setResult(RESULT_OK, perehod2);
            finish();
        });

        btnCancel.setOnClickListener(view -> {
            setResult(RESULT_CANCELED);
            finish();
        });
    }
}
