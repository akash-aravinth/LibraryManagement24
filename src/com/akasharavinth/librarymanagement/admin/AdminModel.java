package com.akasharavinth.librarymanagement.admin;

import com.akasharavinth.librarymanagement.database.DataManagement;
import com.akasharavinth.librarymanagement.models.Admin;

import javax.xml.crypto.Data;

public class AdminModel {

    private static AdminModel adminModel;
    public static AdminModel getInstance(){
        if (adminModel == null)
            adminModel = new AdminModel();
        return adminModel;
    }
    Admin admin1 = new Admin("akash", "akash123", "akash", 8838995890l);
    Admin admin2 = new Admin("aravinth", "aravinth123", "aravinth", 9894297384l);
    Admin admin3 = new Admin("raj", "raj123", "raj", 9876543210l);

    public void addAdminData() {
        DataManagement.getInstance().addAdmin(admin1);
        DataManagement.getInstance().addAdmin(admin2);
        DataManagement.getInstance().addAdmin(admin3);
    }

}
