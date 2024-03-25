package com.akasharavinth.librarymanagement.login;

import java.util.Scanner;

public class LoginView {
    private LoginModel loginModel;

    public LoginView() {
        loginModel = new LoginModel(this);
    }

    Scanner scanner = new Scanner(System.in);

    public void getLogin() {
        System.out.println("Enter Your UserID");
        String userId = scanner.next();
        System.out.println("Enter Your Password");
        String password = scanner.next();
        loginModel.validateUserPassword(userId, password);
    }

    public void showAlert(String alert) {
        System.out.println(alert);
    }
}
