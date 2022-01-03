package com.example.fracis;

public class model {

    String name,barangay,gender;

    public model(String name, String contact, String gender) {
        this.name = name;
        this.barangay = contact;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBarangay() {
        return barangay;
    }

    public void setBarangay(String barangay) {
        this.barangay = barangay;
    }

    public String setGender() {
        return gender;
    }

    public void setGender(String email) {
        this.gender = gender;
    }
}


