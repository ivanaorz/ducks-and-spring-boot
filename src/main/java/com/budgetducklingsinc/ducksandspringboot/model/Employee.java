package com.budgetducklingsinc.ducksandspringboot.model;

public class Employee {

    private int userId;
    private String username;
    private String password;


    public Employee(int userId, String username, String password) {
           this.userId = userId;
           this.username = username;
           this.password = password;
    }

    public Employee() {

    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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
