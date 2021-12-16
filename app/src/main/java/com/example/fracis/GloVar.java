package com.example.fracis;

import android.app.Application;

public class GloVar extends Application {
    private String First_Name;
    private String Middle_Name;
    private String Last_Name;
    private String Ext_Name;
    private String Barangay;
    private String Gender;
    private String Date_of_Birth;
    private String Place_of_Birth;
    private String Contact;
    private String Civil_Status;
    private String Spouse;

    public String getFirst_Name() {
        return First_Name;
    }

    public void setFirst_Name(String first_Name) {
        First_Name = first_Name;
    }

    public String getMiddle_Name() {
        return Middle_Name;
    }

    public void setMiddle_Name(String middle_Name) {
        Middle_Name = middle_Name;
    }

    public String getLast_Name() {
        return Last_Name;
    }

    public void setLast_Name(String last_Name) {
        Last_Name = last_Name;
    }

    public String getExt_Name() {
        return Ext_Name;
    }

    public void setExt_Name(String ext_Name) {
        Ext_Name = ext_Name;
    }

    public String getBarangay() {
        return Barangay;
    }

    public void setBarangay(String barangay) {
        Barangay = barangay;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public String getDate_of_Birth() {
        return Date_of_Birth;
    }

    public void setDate_of_Birth(String date_of_Birth) {
        Date_of_Birth = date_of_Birth;
    }

    public String getPlace_of_Birth() {
        return Place_of_Birth;
    }

    public void setPlace_of_Birth(String place_of_Birth) {
        Place_of_Birth = place_of_Birth;
    }

    public String getContact() {
        return Contact;
    }

    public void setContact(String contact) {
        Contact = contact;
    }

    public String getCivil_Status() {
        return Civil_Status;
    }

    public void setCivil_Status(String civil_Status) {
        Civil_Status = civil_Status;
    }

    public String getSpouse() {
        return Spouse;
    }

    public void setSpouse(String spouse) {
        Spouse = spouse;
    }
}
