package com.campusbuspass.model;

import java.io.Serializable;

/**
 * Represents a bus pass issued to a student for a route.
 */
public class Pass implements Serializable {

    private static final long serialVersionUID = 1L;

    private final String passId;   // generated, e.g. BP-0001
    private final String regNo;    // student reg no
    private final int routeId;     // route reference
    private final String passType; // MONTHLY | SEMESTER
    private final double fee;
    private final String issueDate;  // ISO yyyy-MM-dd
    private String expiryDate;       // ISO yyyy-MM-dd
    private boolean valid;

    public Pass(String passId, String regNo, int routeId, String passType,
                double fee, String issueDate, String expiryDate, boolean valid) {
        this.passId = passId;
        this.regNo = regNo;
        this.routeId = routeId;
        this.passType = passType;
        this.fee = fee;
        this.issueDate = issueDate;
        this.expiryDate = expiryDate;
        this.valid = valid;
    }

    public String getPassId() { return passId; }
    public String getRegNo() { return regNo; }
    public int getRouteId() { return routeId; }
    public String getPassType() { return passType; }
    public double getFee() { return fee; }
    public String getIssueDate() { return issueDate; }
    public String getExpiryDate() { return expiryDate; }
    public void setExpiryDate(String expiryDate) { this.expiryDate = expiryDate; }
    public boolean isValid() { return valid; }
    public void setValid(boolean valid) { this.valid = valid; }

    @Override
    public String toString() {
        return "Pass " + passId + " | " + passType + " | Rs. " + fee
                + " | Valid: " + valid + " | Issued: " + issueDate
                + " | Expires: " + expiryDate;
    }
}