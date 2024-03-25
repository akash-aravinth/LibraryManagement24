package com.akasharavinth.librarymanagement.home;

import com.akasharavinth.librarymanagement.LibraryManagement;
import com.akasharavinth.librarymanagement.login.LoginView;
import com.akasharavinth.librarymanagement.login.SignUpView;

import java.util.Scanner;

public class HomeView {
    Scanner scanner = new Scanner(System.in);

    public void init() {
        System.out.println("Welcome To : " + LibraryManagement.getInstance().getAppName() + " Version : " + LibraryManagement.getInstance().getAppVersion()
                + "  ");
        appStart();
    }

    public void appStart() {
        System.out.println("1 --> Login\n2 --> SignUp\n3 --> Show Books\n4 --> Exit...");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1: {
                LoginView loginView = new LoginView();
                loginView.getLogin();
                break;
            }
            case 2: {
                SignUpView signUpView = new SignUpView();
                signUpView.getSignUp();
                break;
            }
            case 3: {
                System.out.println("You Must Login and View The Books");
                break;
            }
            case 4: {
                System.out.println("Thank you For Using " + LibraryManagement.getInstance().getAppName() + " and the version " +
                        LibraryManagement.getInstance().getAppVersion());
                break;
            }
            default: {
                System.out.println("You must Enter Valid Choice Between 1-4");
                break;
            }
        }
    }
}
