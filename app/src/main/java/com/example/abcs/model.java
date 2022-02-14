package com.example.abcs;

public class model {
    String Name,Email,Comments,Section,Level,permissionid,status;

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

    public String getComments() {
        return Comments;
    }

    public void setComments(String comments) {
        Comments = comments;
    }

    public String getSection() {
        return Section;
    }

    public void setSection(String section) {
        Section = section;
    }

    public String getLevel() {
        return Level;
    }

    public void setLevel(String level) {
        Level = level;
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

    public model(String name, String email, String comments, String section, String level, String permissionid, String status) {
        Name = name;
        Email = email;
        Comments = comments;
        Section = section;
        Level = level;
        this.permissionid = permissionid;
        this.status = status;
    }

    model(){

    }

}
