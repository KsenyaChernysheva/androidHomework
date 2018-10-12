package com.example.xenya.navigationdrawer;

import java.io.Serializable;

import androidx.annotation.DrawableRes;

public class Student implements Serializable {

    @DrawableRes
    private int id;
    private int image;
    private String name;
    private String lastName;
    private String phone;

    public Student(int id, int image, String name, String lastName, String phone) {
        this.id = id;
        this.image = image;
        this.name = name;
        this.lastName = lastName;
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;

        Student student = (Student) o;

        if (id != student.id) return false;
        if (image != student.image) return false;
        if (name != null ? !name.equals(student.name) : student.name != null) return false;
        if (lastName != null ? !lastName.equals(student.lastName) : student.lastName != null)
            return false;
        return phone != null ? phone.equals(student.phone) : student.phone == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + image;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        return result;
    }
}
