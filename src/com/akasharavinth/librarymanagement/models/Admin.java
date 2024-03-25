package com.akasharavinth.librarymanagement.models;

public class Admin {
    private String adminName;
    private String adminPassword;
    private String adminId;
    private long adminPhoneNo;

    public Admin(String adminName, String adminPassword, String adminId, long adminPhoneNo) {
        this.adminName = adminName;
        this.adminPassword = adminPassword;
        this.adminId = adminId;
        this.adminPhoneNo = adminPhoneNo;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }

    public String getAdminId() {
        return adminId;
    }

    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }

    public long getAdminPhoneNo() {
        return adminPhoneNo;
    }

    public void setAdminPhoneNo(long adminPhoneNo) {
        this.adminPhoneNo = adminPhoneNo;
    }

}
