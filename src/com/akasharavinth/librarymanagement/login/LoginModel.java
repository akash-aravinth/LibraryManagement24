package com.akasharavinth.librarymanagement.login;

import com.akasharavinth.librarymanagement.database.DataManagement;
import com.akasharavinth.librarymanagement.librarysetup.LibrarySetupView;
import com.akasharavinth.librarymanagement.models.Admin;
import com.akasharavinth.librarymanagement.models.User;
import com.akasharavinth.librarymanagement.useraccess.UserAccessView;

public class LoginModel {
    private LoginView loginView;

    LoginModel(LoginView loginView) {
        this.loginView = loginView;
    }

    public void validateUserPassword(String userId, String password) {
        if (validateAdmin(userId, password)) {
            loginView.showAlert("Admin Login Successfully");
            LibrarySetupView librarySetupView = new LibrarySetupView();
            librarySetupView.init();
        } else if (validateUser(userId, password)) {
            loginView.showAlert("User Login Successfully");
            User user = DataManagement.getInstance().getUser(userId);
            UserAccessView userAccessView = new UserAccessView();
            userAccessView.init(user);
        } else {
            loginView.showAlert("Please Enter Valid UserId and Password");
            loginView.getLogin();
        }
    }

    private boolean validateUser(String userId, String password) {
        for (User u : DataManagement.getInstance().getUserList()) {
            if (u.getUserId().equals(userId) && u.getUserPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    private boolean validateAdmin(String userId, String password) {
        for (Admin a : DataManagement.getInstance().getAdminList()) {
            if (a.getAdminId().equals(userId) && a.getAdminPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

}
