package com.example.abcs;

public class Teacherdowndata {

    String uid,url10,email;

    public Teacherdowndata(){}

    public Teacherdowndata(String uid, String url10, String email) {
        this.uid = uid;
        this.url10 = url10;
        this.email = email;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getUrl10() {
        return url10;
    }

    public void setUrl10(String url10) {
        this.url10 = url10;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
