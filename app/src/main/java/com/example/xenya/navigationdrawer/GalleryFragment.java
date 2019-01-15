package com.example.xenya.navigationdrawer;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import io.reactivex.Observable;

public class GalleryFragment extends Fragment {

    private StudentListAdapter adapter;
    private List<Student> studentList;
    private ProgressBar progressBar;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_gallery, container, false);
    }

    @SuppressLint("CheckResult")
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        studentList = StudentHelper.getStudents();
        adapter = new StudentListAdapter();

        RecyclerView rvStudents = view.findViewById(R.id.rv_students);
        rvStudents.setLayoutManager(new LinearLayoutManager(getContext()));
        rvStudents.setAdapter(adapter);

        progressBar = view.findViewById(R.id.progress_bar);
        getStudentObservable()
                .toList()
                .subscribe(adapter::setStudentList,
                        error -> Toast.makeText(getContext(), "Error", Toast.LENGTH_SHORT).show());

        setHasOptionsMenu(true);
    }

    private Observable<Student> getStudentObservable() {
        return Observable.fromIterable(studentList)
                .take(8)
                .filter(student -> student.getId() > 2)
                .map(student -> {
                    student.setName(student.getName() + student.getName().length());
                    return student;
                })
                .doOnSubscribe(disposable -> progressBar.setVisibility(View.VISIBLE))
                .doAfterTerminate(() -> progressBar.setVisibility(View.GONE));
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
                getStudentObservable()
                        .toSortedList((student, student1) -> student.getName().compareTo(student1.getName()))
                        .subscribe(adapter::setStudentList);
                break;
            case R.id.menu_by_phone:
                getStudentObservable()
                        .toSortedList((student, student1) -> student.getPhone().compareTo(student1.getPhone()))
                        .subscribe(adapter::setStudentList);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
