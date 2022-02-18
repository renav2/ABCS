package com.example.abcs;

public class TeacherData {

    String Address,DOB,Department,Designation,Email,Empolyee_No,Gender,Name,Mobile_No,Password;

    public TeacherData(){

    }
    public TeacherData(String address, String DOB, String department, String designation, String email, String empolyee_No, String gender, String name, String mobile_No, String password) {
        Address = address;
        this.DOB = DOB;
        Department = department;
        Designation = designation;
        Email = email;
        Empolyee_No = empolyee_No;
        Gender = gender;
        Name = name;
        Mobile_No = mobile_No;
        Password = password;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public String getDepartment() {
        return Department;
    }

    public void setDepartment(String department) {
        Department = department;
    }

    public String getDesignation() {
        return Designation;
    }

    public void setDesignation(String designation) {
        Designation = designation;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getEmpolyee_No() {
        return Empolyee_No;
    }

    public void setEmpolyee_No(String empolyee_No) {
        Empolyee_No = empolyee_No;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getMobile_No() {
        return Mobile_No;
    }

    public void setMobile_No(String mobile_No) {
        Mobile_No = mobile_No;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}
