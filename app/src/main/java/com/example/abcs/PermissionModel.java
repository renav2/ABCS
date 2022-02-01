package com.example.abcs;

public class PermissionModel {
    String Name,Prn;

    public PermissionModel() {
    }

    public PermissionModel(String name, String prn) {
        Name = name;
        Prn = prn;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPrn() {
        return Prn;
    }

    public void setPrn(String prn) {
        Prn = prn;
    }
}
