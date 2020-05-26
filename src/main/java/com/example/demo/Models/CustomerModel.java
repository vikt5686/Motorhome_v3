package com.example.demo.Models;

public class CustomerModel {

    private String firstName;
    private String lastName;
    private long cpr;
    private String adress;
    private long phoneNumber;
    private String email;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public long getCpr() {
        return cpr;
    }

    public void setCpr(long cpr) {
        this.cpr = cpr;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public CustomerModel(String firstName, String lastName, long cpr, String adress, long phoneNumber, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.cpr = cpr;
        this.adress = adress;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }
}
