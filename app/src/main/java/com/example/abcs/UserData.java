package com.example.abcs;

public class UserData {
    String Name,mobile_no,assignno;
    UserData(){

    }

    public UserData(String name, String mobile_no, String assignno) {
        Name = name;
        this.mobile_no = mobile_no;
        this.assignno = assignno;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getMobile_no() {
        return mobile_no;
    }

    public void setMobile_no(String mobile_no) {
        this.mobile_no = mobile_no;
    }

    public String getAssignno() {
        return assignno;
    }

    public void setAssignno(String assignno) {
        this.assignno = assignno;
    }
}
