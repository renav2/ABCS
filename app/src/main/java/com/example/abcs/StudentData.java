package com.example.abcs;

import androidx.annotation.NonNull;

public class StudentData {
    String Name, Email, mobile_no, Address, Academic_year, Category, _Class, assignno, Admission_type, DOB;
    String Gender;

    public StudentData(String gender) {
        Gender = gender;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public StudentData(){}
    public StudentData(String name, String email, String mobile_no, String address, String academic_year, String category, String _Class, String assignno, String admission_type, String DOB) {
        Name = name;
        Email = email;
        this.mobile_no = mobile_no;
        Address = address;
        Academic_year = academic_year;
        Category = category;
        this._Class = _Class;
        this.assignno = assignno;
        Admission_type = admission_type;
        this.DOB = DOB;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getMobile_no() {
        return mobile_no;
    }

    public void setMobile_no(String mobile_no) {
        this.mobile_no = mobile_no;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getAcademic_year() {
        return Academic_year;
    }

    public void setAcademic_year(String academic_year) {
        Academic_year = academic_year;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }

    public String get_Class() {
        return _Class;
    }

    public void set_Class(String _Class) {
        this._Class = _Class;
    }

    public String getAssignno() {
        return assignno;
    }

    public void setAssignno(String assignno) {
        this.assignno = assignno;
    }

    public String getAdmission_type() {
        return Admission_type;
    }

    public void setAdmission_type(String admission_type) {
        Admission_type = admission_type;
    }

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }
}