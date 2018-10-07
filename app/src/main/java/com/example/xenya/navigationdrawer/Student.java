package com.example.xenya.navigationdrawer;

import java.io.Serializable;

import androidx.annotation.DrawableRes;

public class Student implements Serializable {

    @DrawableRes
    private int image;
    private String name;
    private String lastName;
    private String phone;

    public Student(int image, String name, String lastName, String phone) {
        this.image = image;
        this.name = name;
        this.lastName = lastName;
        this.phone = phone;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
