package com.project.cuebue.dtb;

public class UserDetails {

    private String NameUser;
    private String Psword;

    //constructor
    public UserDetails(String nameUser, String psword) {
        this.NameUser = nameUser;
        this.Psword = psword;
    }

    public UserDetails() {

    }

    //get and set
    public String getNameUser() {
        return NameUser;
    }

    public void setNameUser(String nameUser) {
        NameUser = nameUser;
    }

    public String getPsword() {
        return Psword;
    }

    public void setPsword(String psword) {
        Psword = psword;
    }
}
