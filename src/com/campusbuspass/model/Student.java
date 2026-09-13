package com.campusbuspass.model;

import java.io.Serializable;

/**
 * Represents a student registered with the Campus Bus Pass system.
 */
public class Student implements Serializable {

    private static final long serialVersionUID = 1L;

    private final String regNo;
    private String name;
    private String category;      // DAY_SCHOLAR | HOSTELLER
    private String email;
    private String phone;
    private String address;
    private String regDate;       // ISO yyyy-MM-dd

    public Student(String regNo, String name, String category, String email,
                   String phone, String address, String regDate) {
        this.regNo = regNo;
        this.name = name;
        this.category = category;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.regDate = regDate;
    }

    public String getRegNo() { return regNo; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
    public String getRegDate() { return regDate; }
    public void setRegDate(String regDate) { this.regDate = regDate; }

    @Override
    public String toString() {
        return "RegNo: " + regNo
                + "\nName: " + name
                + "\nCategory: " + category
                + "\nEmail: " + email
                + "\nPhone: " + phone
                + "\nAddress: " + address
                + "\nRegistered on: " + regDate;
    }
}