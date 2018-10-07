package com.example.xenya.navigationdrawer;

import java.util.ArrayList;
import java.util.List;

public class StudentHelper {
    public static List<Student> getStudents() {
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student(
                R.drawable.me,
                "Ксюсха",
                "Че",
                "1234567890"
        ));
        studentList.add(new Student(
                R.drawable.ayd,
                "Айдер",
                "Меметов",
                "12345678434"
        ));
        studentList.add(new Student(
                R.drawable.dan,
                "Данис",
                "Замалиев",
                "12345678434"
        ));
        studentList.add(new Student(
                R.drawable.el,
                "Лучшая",
                "Соседка",
                "12345678434"
        ));
        studentList.add(new Student(
                R.drawable.ern,
                "Твой",
                "Сосед",
                "12345678434"
        ));
        studentList.add(new Student(
                R.drawable.grish,
                "Тимур",
                "Гришин",
                "12345678434"
        ));
        studentList.add(new Student(
                R.drawable.guz,
                "Гузель",
                "Гузель",
                "12345678434"
        ));
        studentList.add(new Student(
                R.drawable.karp,
                "Карпик",
                "Ксюшенция",
                "12345678434"
        ));
        studentList.add(new Student(
                R.drawable.mer,
                "Настя",
                "Меренова",
                "12345678434"
        ));
        studentList.add(new Student(
                R.drawable.niy,
                "Нияз",
                "Уразаев",
                "12345678434"
        ));
        studentList.add(new Student(
                R.drawable.stasya,
                "Стася",
                "Александровская",
                "12345678434"
        ));
        studentList.add(new Student(
                R.drawable.tim,
                "Тим",
                "Батон",
                "12345678434"
        ));

        return studentList;
    }
}
