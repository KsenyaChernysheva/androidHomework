package com.example.xenya.navigationdrawer;

import java.util.ArrayList;
import java.util.List;

public class StudentHelper {
    public static List<Student> getStudents() {
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student(
                0,
                R.drawable.me,
                "Ксюсха",
                "Че",
                "1234567890"
        ));
        studentList.add(new Student(
                1,
                R.drawable.ayd,
                "Айдер",
                "Меметов",
                "4859285"
        ));
        studentList.add(new Student(
                2,
                R.drawable.dan,
                "Данис",
                "Замалиев",
                "12345678434"
        ));
        studentList.add(new Student(
                3,
                R.drawable.el,
                "Лучшая",
                "Соседка",
                "8982498"
        ));
        studentList.add(new Student(
                4,
                R.drawable.ern,
                "Твой",
                "Сосед",
                "39765"
        ));
        studentList.add(new Student(
                5,
                R.drawable.grish,
                "Тимур",
                "Гришин",
                "1907587435"
        ));
        studentList.add(new Student(
                6,
                R.drawable.guz,
                "Гузель",
                "Гузель",
                "234758293"
        ));
        studentList.add(new Student(
                7,
                R.drawable.karp,
                "Карпик",
                "Ксюшенция",
                "01194385"
        ));
        studentList.add(new Student(
                8,
                R.drawable.mer,
                "Настя",
                "Меренова",
                "0398456"
        ));
        studentList.add(new Student(
                9,
                R.drawable.niy,
                "Нияз",
                "Уразаев",
                "119234808"
        ));
        studentList.add(new Student(
                10,
                R.drawable.stasya,
                "Стася",
                "Александровская",
                "2345209"
        ));
        studentList.add(new Student(
                11,
                R.drawable.tim,
                "Тим",
                "Батон",
                "128349839"
        ));

        return studentList;
    }
}
