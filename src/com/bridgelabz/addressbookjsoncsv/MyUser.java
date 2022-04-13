package com.bridgelabz.addressbookjsoncsv;

import com.opencsv.bean.CsvBindByPosition;

public class MyUser {

    @CsvBindByPosition(position = 0)
    private String name;

    @CsvBindByPosition(position = 1)
    private String email;

    @CsvBindByPosition(position = 2)
    private String phoneNo;

    @CsvBindByPosition(position = 3)
    private String country;

    public MyUser() {

    }
    @Override
    public String toString() {
        return name + " | " + email + " | " + phoneNo + " | " + country;
    }
    public MyUser(String name, String email, String phoneNo, String country) {
        this.name = name;
        this.email = email;
        this.phoneNo = phoneNo;
        this.country = country;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}

