package com.example.abcs;

public class zero_pay_data {
  //  String paymentid,paidamount,mobile_no,branch,_class,Section,Name,Email,remaining_fees,installment,unicid_assignno;
String assignno,Branch,Email,_Class,mobile_no,Name,collagepayemtfees____;

    public zero_pay_data(String collagepayemtfees____) {
        this.collagepayemtfees____ = collagepayemtfees____;
    }

    public String getCollagepayemtfees____() {
        return collagepayemtfees____;
    }

    public void setCollagepayemtfees____(String collagepayemtfees____) {
        this.collagepayemtfees____ = collagepayemtfees____;
    }

    public zero_pay_data(String assignno, String branch, String email, String _Class, String mobile_no, String name) {
        this.assignno = assignno;
        Branch = branch;
        Email = email;
        this._Class = _Class;
        this.mobile_no = mobile_no;
        Name = name;
    }

    public String getAssignno() {
        return assignno;
    }

    public void setAssignno(String assignno) {
        this.assignno = assignno;
    }

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

    public String get_Class() {
        return _Class;
    }

    public void set_Class(String _Class) {
        this._Class = _Class;
    }

    public String getMobile_no() {
        return mobile_no;
    }

    public void setMobile_no(String mobile_no) {
        this.mobile_no = mobile_no;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    zero_pay_data(){

    }
}
