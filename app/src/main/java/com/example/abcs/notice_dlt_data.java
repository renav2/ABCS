package com.example.abcs;

public class notice_dlt_data {
    String Authority, Description, Highlight, Notice_Date, Subject, pdfurl1;

    public notice_dlt_data(String authority, String description, String highlight, String notice_Date, String subject, String pdfurl1) {
        Authority = authority;
        Description = description;
        Highlight = highlight;
        Notice_Date = notice_Date;
        Subject = subject;
        this.pdfurl1 = pdfurl1;
    }

    public String getAuthority() {
        return Authority;
    }

    public void setAuthority(String authority) {
        Authority = authority;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getHighlight() {
        return Highlight;
    }

    public void setHighlight(String highlight) {
        Highlight = highlight;
    }

    public String getNotice_Date() {
        return Notice_Date;
    }

    public void setNotice_Date(String notice_Date) {
        Notice_Date = notice_Date;
    }

    public String getSubject() {
        return Subject;
    }

    public void setSubject(String subject) {
        Subject = subject;
    }

    public String getPdfurl1() {
        return pdfurl1;
    }

    public void setPdfurl1(String pdfurl1) {
        this.pdfurl1 = pdfurl1;
    }

    notice_dlt_data(){

    }

}