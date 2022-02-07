package com.example.abcs;

public class noticemodel {
    String Notice_Date ,Subject,Description,Highlight,Authority;

    public noticemodel() {

    }

    public noticemodel(String notice_Date, String subject, String authority) {
        Notice_Date = notice_Date;
        Subject = subject;
        Authority = authority;
    }

    public noticemodel(String notice_Date, String subject, String description, String highlight, String authority) {
        Notice_Date = notice_Date;
        Subject = subject;
        Description = description;
        Highlight = highlight;
        Authority = authority;
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

    public String getAuthority() {
        return Authority;
    }

    public void setAuthority(String authority) {
        Authority = authority;
    }
}
