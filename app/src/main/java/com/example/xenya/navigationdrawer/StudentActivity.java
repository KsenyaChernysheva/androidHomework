package com.example.xenya.navigationdrawer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

public class StudentActivity extends AppCompatActivity {
    private static final String KEY_STUDENT = "STUDENT";
    private ImageView ivStudent;
    private TextView tvStudentName;
    private TextView tvStudentPhone;

    public static void start(Context context, Student student) {
        Intent starter = new Intent(context, StudentActivity.class);
        starter.putExtra(KEY_STUDENT, student);
        context.startActivity(starter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ivStudent = findViewById(R.id.iv_stud);
        tvStudentName = findViewById(R.id.tv_stud_name);
        tvStudentPhone = findViewById(R.id.tv_stud_phone);

        Student student = (Student) getIntent().getSerializableExtra(KEY_STUDENT);

        ivStudent.setImageResource(student.getImage());
        tvStudentName.setText(String.format("%s %s", student.getName(), student.getLastName()));
        tvStudentPhone.setText(student.getPhone());
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
