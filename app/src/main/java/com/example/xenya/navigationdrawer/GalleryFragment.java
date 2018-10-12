package com.example.xenya.navigationdrawer;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class GalleryFragment extends Fragment {

    private StudentListAdapter adapter;
    private List<Student> studentList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_gallery, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        studentList = StudentHelper.getStudents();
        adapter = new StudentListAdapter();

        RecyclerView rvStudents = view.findViewById(R.id.rv_students);
        rvStudents.setLayoutManager(new LinearLayoutManager(getContext()));
        rvStudents.setAdapter(adapter);

        adapter.setStudentList(studentList);

        setHasOptionsMenu(true);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);

        inflater.inflate(R.menu.menu_sort, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_by_name:
                Collections.sort(studentList, new Comparator<Student>() {
                    @Override
                    public int compare(Student student, Student student1) {
                        return student.getName().compareTo(student1.getName());
                    }
                });
                adapter.setStudentList(studentList);
                break;
            case R.id.menu_by_phone:
                Collections.sort(studentList, new Comparator<Student>() {
                    @Override
                    public int compare(Student student, Student student1) {
                        return student.getPhone().compareTo(student1.getPhone());
                    }
                });
                adapter.setStudentList(studentList);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
