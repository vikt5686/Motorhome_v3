package com.example.demo.Models;

import java.util.Date;

public class RentalModel {

    private Date dateOfSale;
    private double saleAmount;
    //Something
    private Date returnDate;
    private String customerFirstName;
    private String customerLastName;
    private String customerAddress;
    private long customerPhoNo;
    private String customerEmail;

    public String getCustomerFirstName() {
        return customerFirstName;
    }

    public String getCustomerLastName() {
        return customerLastName;
    }
}
