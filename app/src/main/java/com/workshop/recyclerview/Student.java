package com.workshop.recyclerview;

/**
 * Created by rohitjain on 24/12/15.
 */
public class Student {
    private String name;
    private int rollNumber;
    private boolean gender;

    public Student(String name, int rollNumber, boolean gender) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public boolean isGender() {
        return gender;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRollNumber(int rollNumber) {
        this.rollNumber = rollNumber;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }
}
