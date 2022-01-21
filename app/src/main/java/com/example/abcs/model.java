package com.example.abcs;

public class model {
    String Name,Email;

    public model() {
    }

    public model(String name, String email) {
        this.Name = name;
        this.Email = email;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        this.Email = email;
    }

}
