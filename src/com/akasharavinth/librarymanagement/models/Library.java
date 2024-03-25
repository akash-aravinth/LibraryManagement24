package com.akasharavinth.librarymanagement.models;

public class Library {
    private String libraryName;
    private int libraryId;
    private long libraryPhoneNo;
    private String libraryEmailId;
    private String libraryAddress;

    public String getLibraryName() {
        return libraryName;
    }

    public void setLibraryName(String libraryName) {
        this.libraryName = libraryName;
    }

    public int getLibraryId() {
        return libraryId;
    }

    public void setLibraryId(int libraryId) {
        this.libraryId = libraryId;
    }

    public long getLibraryPhoneNo() {
        return libraryPhoneNo;
    }

    public void setLibraryPhoneNo(long libraryPhoneNo) {
        this.libraryPhoneNo = libraryPhoneNo;
    }

    public String getLibraryEmailId() {
        return libraryEmailId;
    }

    public void setLibraryEmailId(String libraryEmailId) {
        this.libraryEmailId = libraryEmailId;
    }

    public String getLibraryAddress() {
        return libraryAddress;
    }

    public void setLibraryAddress(String libraryAddress) {
        this.libraryAddress = libraryAddress;
    }
}
