package com.budgetducklingsinc.ducksandspringboot.model;

public class Employee {


    private String username;
    private String password;

    public Employee(String username, String password) {

           this.username = username;
           this.password = password;
    }

    public Employee() {

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
}