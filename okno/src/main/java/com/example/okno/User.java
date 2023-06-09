package com.example.okno;

public class User {
    private String firstname;
    private String fullname;
    private String username;
    private String password;
    private String gender;

    public User(String firstname, String fullname, String username, String password, String gender) {
        this.firstname = firstname;
        this.fullname = fullname;
        this.username = username;
        this.password = password;
        this.gender = gender;
    }

    public User() {
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }


}
