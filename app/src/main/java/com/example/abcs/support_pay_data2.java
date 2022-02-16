package com.example.abcs;

public class support_pay_data2 {
    support_pay_data2(){

    }
String Branch,Email,Name,_Class,assignno,game,student_issue;

    public String getBranch() {
        return Branch;
    }

    public void setBranch(String branch) {
        Branch = branch;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
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

    public String getGame() {
        return game;
    }

    public void setGame(String game) {
        this.game = game;
    }

    public String getStudent_issue() {
        return student_issue;
    }

    public void setStudent_issue(String student_issue) {
        this.student_issue = student_issue;
    }

    public support_pay_data2(String branch, String email, String name, String _Class, String assignno, String game, String student_issue) {
        Branch = branch;
        Email = email;
        Name = name;
        this._Class = _Class;
        this.assignno = assignno;
        this.game = game;
        this.student_issue = student_issue;
    }
}
