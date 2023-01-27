package com.budgetducklingsinc.ducksandspringboot.model;

public class PaymentTable {

    private int id;
    private String title;
    private String dateOfPayment;
    private String description;
    private String category;
    private double price;



    public PaymentTable(int id, String title, String dateOfPayment, String description, String category, double price) {
        this.id = id;
        this.title = title;
        this.dateOfPayment = dateOfPayment;
        this.description = description;
        this.category = category;
        this.price = price;

    }

    public PaymentTable() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDateOfPayment() {
        return dateOfPayment;
    }

    public void setDateOfPayment(String dateOfPayment) {
        this.dateOfPayment = dateOfPayment;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


}


