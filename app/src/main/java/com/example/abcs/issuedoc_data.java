package com.example.abcs;

public class issuedoc_data {
    public issuedoc_data(String documentname) {
        this.documentname = documentname;
    }

    public String getDocumentname() {
        return documentname;
    }

    public void setDocumentname(String documentname) {
        this.documentname = documentname;
    }

    String Name,Rollno,date,dept,document,name,yr,documentname;

    public issuedoc_data(String name, String rollno, String date, String dept, String document, String name1, String yr) {
        Name = name;
        Rollno = rollno;
        this.date = date;
        this.dept = dept;
        this.document = document;
        this.name = name1;
        this.yr = yr;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getYr() {
        return yr;
    }

    public void setYr(String yr) {
        this.yr = yr;
    }

    public String getRollno() {
        return Rollno;
    }

    public void setRollno(String rollno) {
        Rollno = rollno;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    issuedoc_data(){

    }

}
