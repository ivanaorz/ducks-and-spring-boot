package com.budgetducklingsinc.ducksandspringboot.model;

public class EmployeeTable {


    private String username;
    private String password;

    public EmployeeTable( String username, String password) {

           this.username = username;
           this.password = password;
    }

    public EmployeeTable() {

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
