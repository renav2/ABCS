package com.example.abcs;

public class suport_data {

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

    public String get_class() {
        return _class;
    }

    public void set_class(String _class) {
        this._class = _class;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getInstallment() {
        return installment;
    }

    public void setInstallment(String installment) {
        this.installment = installment;
    }

    public String getMobile_no() {
        return mobile_no;
    }

    public void setMobile_no(String mobile_no) {
        this.mobile_no = mobile_no;
    }

    public String getPaidamount() {
        return paidamount;
    }

    public void setPaidamount(String paidamount) {
        this.paidamount = paidamount;
    }


    public String getSecrem() {
        return secrem;
    }

    public void setSecrem(String secrem) {
        this.secrem = secrem;
    }

    public String getThirdinstrem() {
        return thirdinstrem;
    }

    public String getPaymentid() {
        return paymentid;
    }

    public void setPaymentid(String paymentid) {
        this.paymentid = paymentid;
    }

    public suport_data(String paymentid) {
        this.paymentid = paymentid;
    }

    public void setThirdinstrem(String thirdinstrem) {
        this.thirdinstrem = thirdinstrem;
    }

    public String getFourthrem() {
        return fourthrem;
    }

    public void setFourthrem(String fourthrem) {
        this.fourthrem = fourthrem;
    }

    String Email,Name,Section,_class,branch,installment,mobile_no,paidamount,paymentid,secrem,thirdinstrem,fourthrem ;

    public suport_data(String email, String name, String section, String _class, String branch, String installment, String mobile_no, String paidamount, String paymentid, String secrem, String thirdinstrem, String fourthrem) {
        Email = email;
        Name = name;
        Section = section;
        this._class = _class;
        this.branch = branch;
        this.installment = installment;
        this.mobile_no = mobile_no;
        this.paidamount = paidamount;

        this.secrem = secrem;
        this.thirdinstrem = thirdinstrem;
        this.fourthrem = fourthrem;
    }

    suport_data(){

    }



}
