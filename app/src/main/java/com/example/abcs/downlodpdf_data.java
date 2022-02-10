package com.example.abcs;

public class downlodpdf_data {
String pdfurl1,Subject;

    downlodpdf_data(){

    }
    public String getPdfurl1() {
        return pdfurl1;
    }

    public void setPdfurl1(String pdfurl1) {
        this.pdfurl1 = pdfurl1;
    }

    public String getSubject() {
        return Subject;
    }

    public void setSubject(String subject) {
        Subject = subject;
    }

    public downlodpdf_data(String pdfurl1, String subject) {
        this.pdfurl1 = pdfurl1;
        Subject = subject;
    }
}
