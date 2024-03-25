package com.akasharavinth.librarymanagement.models;

import com.akasharavinth.librarymanagement.database.DataManagement;

import java.util.ArrayList;

public class User {
    private static long userCount = DataManagement.getInstance().getUserList().size();

    private long userNo;
    private String userId;
    private String userPassword;
    private long userPhoneNo;
    private String userEmailId;
    private String userAddress;
    private ArrayList<Long> dueBooks = new ArrayList<>();

    public void addDueBooks(long bookId){
        dueBooks.add(bookId);
    }
    public ArrayList<Long> getDueBookList(){
        return dueBooks;
    }

    public long getUserNo() {
        return userNo;
    }

    public void setUserNo() {
        this.userNo = userCount++;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public long getUserPhoneNo() {
        return userPhoneNo;
    }

    public void setUserPhoneNo(long userPhoneNo) {
        this.userPhoneNo = userPhoneNo;
    }

    public String getUserEmailId() {
        return userEmailId;
    }

    public void setUserEmailId(String userEmailId) {
        this.userEmailId = userEmailId;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }
}
