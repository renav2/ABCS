package com.example.abcs;

public class PermissonData {

    String Comments,Email,Name,Section,permissionid,status,Level;

    public PermissonData(){}

    public PermissonData(String comments, String email, String name, String section, String permissionid, String status, String level) {
        Comments = comments;
        Email = email;
        Name = name;
        Section = section;
        this.permissionid = permissionid;
        this.status = status;
        Level = level;
    }

    public String getComments() {
        return Comments;
    }

    public void setComments(String comments) {
        Comments = comments;
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

    public String getPermissionid() {
        return permissionid;
    }

    public void setPermissionid(String permissionid) {
        this.permissionid = permissionid;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getLevel() {
        return Level;
    }

    public void setLevel(String level) {
        Level = level;
    }
}
