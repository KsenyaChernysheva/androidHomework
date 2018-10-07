package com.example.xenya.navigationdrawer;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class StudentListAdapter extends RecyclerView.Adapter<StudentListAdapter.StudentViewHolder>{

    private List<Student> studentList;

    public StudentListAdapter(@NonNull List<Student> studentList) {
        this.studentList = studentList;
    }

    @NonNull
    @Override
    public StudentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_student, parent, false);
        return new StudentViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentViewHolder holder, int position) {
        holder.bind(studentList.get(position));
    }

    @Override
    public int getItemCount() {
        return studentList.size();
    }

    class StudentViewHolder extends RecyclerView.ViewHolder {

        ImageView ivStudent;
        TextView tvStudentName;
        TextView tvStudentPhone;

        StudentViewHolder(@NonNull View itemView) {
            super(itemView);
            ivStudent = itemView.findViewById(R.id.iv_student);
            tvStudentName = itemView.findViewById(R.id.tv_student_name);
            tvStudentPhone = itemView.findViewById(R.id.tv_student_phone);
        }

        void bind(final Student student) {
            ivStudent.setImageResource(student.getImage());
            tvStudentName.setText(String.format("%s %s", student.getName(), student.getLastName()));
            tvStudentPhone.setText(student.getPhone());

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    StudentActivity.start(itemView.getContext(), student);
                }
            });
        }
    }
}
