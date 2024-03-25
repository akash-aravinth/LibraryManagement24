package com.akasharavinth.librarymanagement;

import com.akasharavinth.librarymanagement.admin.AdminModel;
import com.akasharavinth.librarymanagement.home.HomeView;
import com.akasharavinth.librarymanagement.managebooks.ManageBooksView;
import com.akasharavinth.librarymanagement.manageuser.ManageUserView;

public class LibraryManagement {
    private String appName = "Library Management";
    private String appVersion = "0.1.0";

    public String getAppName() {
        return appName;
    }


    public String getAppVersion() {
        return appVersion;
    }


    public static LibraryManagement libraryManagement;

    public static LibraryManagement getInstance() {
        if (libraryManagement == null)
            libraryManagement = new LibraryManagement();
        return libraryManagement;
    }

    public void init() {
        AdminModel.getInstance().addAdminData();
        HomeView homeView = new HomeView();
        homeView.init();
    }

    public static void main(String[] args) {
        LibraryManagement.getInstance().init();
    }
}
