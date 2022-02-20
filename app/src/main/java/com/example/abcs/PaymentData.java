package com.example.abcs;

public class PaymentData {

    String Email, Name, Section, unicid_assignno;
    //Exam
    String backlogformno, examformno, student_prn_no;
    //Hostel
    String paidamount, paymentid;
    //College
    String installment, totalfees, remaning_fee;

    public PaymentData() {
    }

    public PaymentData(String email, String name, String section, String unicid_assignno, String backlogformno, String examformno, String status, String student_prn_no, String paidamount, String paymentid, String installment, String totalfees, String remaning_fee) {
        Email = email;
        Name = name;
        Section = section;
        this.unicid_assignno = unicid_assignno;
        this.backlogformno = backlogformno;
        this.examformno = examformno;

        this.student_prn_no = student_prn_no;
        this.paidamount = paidamount;
        this.paymentid = paymentid;
        this.installment = installment;
        this.totalfees = totalfees;
        this.remaning_fee = remaning_fee;
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

    public String getSection() {
        return Section;
    }

    public void setSection(String section) {
        Section = section;
    }

    public String getUnicid_assignno() {
        return unicid_assignno;
    }

    public void setUnicid_assignno(String unicid_assignno) {
        this.unicid_assignno = unicid_assignno;
    }

    public String getBacklogformno() {
        return backlogformno;
    }

    public void setBacklogformno(String backlogformno) {
        this.backlogformno = backlogformno;
    }

    public String getExamformno() {
        return examformno;
    }

    public void setExamformno(String examformno) {
        this.examformno = examformno;
    }



    public String getStudent_prn_no() {
        return student_prn_no;
    }

    public void setStudent_prn_no(String student_prn_no) {
        this.student_prn_no = student_prn_no;
    }

    public String getPaidamount() {
        return paidamount;
    }

    public void setPaidamount(String paidamount) {
        this.paidamount = paidamount;
    }

    public String getPaymentid() {
        return paymentid;
    }

    public void setPaymentid(String paymentid) {
        this.paymentid = paymentid;
    }

    public String getInstallment() {
        return installment;
    }

    public void setInstallment(String installment) {
        this.installment = installment;
    }

    public String getTotalfees() {
        return totalfees;
    }

    public void setTotalfees(String totalfees) {
        this.totalfees = totalfees;
    }

    public String getRemaning_fee() {
        return remaning_fee;
    }

    public void setRemaning_fee(String remaning_fee) {
        this.remaning_fee = remaning_fee;
    }
}