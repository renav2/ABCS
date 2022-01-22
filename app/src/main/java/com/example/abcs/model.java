package com.example.abcs;

public class model {
    String Name,Email,Comments,Section,Level;

    public model() {
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

    public model(String name, String email, String comments, String section, String level) {
        this.Name = name;
        this.Email = email;
        this.Comments=comments;
        this.Section=section;
        this.Level=level;
    }



}
