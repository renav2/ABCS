package com.example.abcs;

public class Admin_Collage_payrecord_data {
    Admin_Collage_payrecord_data(){

    }
    String paymentid,paidamount,mobile_no,branch,_class,Section,Name,Email,remaining_fees,installment,unicid_assignno;

    public String getUnicid_assignno() {
        return unicid_assignno;
    }

    public void setUnicid_assignno(String unicid_assignno) {
        this.unicid_assignno = unicid_assignno;
    }

    public Admin_Collage_payrecord_data(String paymentid, String paidamount, String mobile_no, String branch, String _class, String section, String name, String email, String remaining_fees, String installment, String unicid_assignno) {
        this.paymentid = paymentid;
        this.paidamount = paidamount;
        this.mobile_no = mobile_no;
        this.branch = branch;
        this._class = _class;
        Section = section;
        Name = name;
        Email = email;
        this.remaining_fees = remaining_fees;
        this.installment = installment;
        this.unicid_assignno = unicid_assignno;
    }

    public String getPaymentid() {
        return paymentid;
    }

    public void setPaymentid(String paymentid) {
        this.paymentid = paymentid;
    }

    public String getPaidamount() {
        return paidamount;
    }

    public void setPaidamount(String paidamount) {
        this.paidamount = paidamount;
    }

    public String getMobile_no() {
        return mobile_no;
    }

    public void setMobile_no(String mobile_no) {
        this.mobile_no = mobile_no;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String get_class() {
        return _class;
    }

    public void set_class(String _class) {
        this._class = _class;
    }

    public String getSection() {
        return Section;
    }

    public void setSection(String section) {
        Section = section;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getRemaining_fees() {
        return remaining_fees;
    }

    public void setRemaining_fees(String remaining_fees) {
        this.remaining_fees = remaining_fees;
    }

    public String getInstallment() {
        return installment;
    }

    public void setInstallment(String installment) {
        this.installment = installment;
    }


}
