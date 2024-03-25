package com.akasharavinth.librarymanagement.login;

import com.akasharavinth.librarymanagement.home.HomeView;

import java.util.Scanner;

public class SignUpView {
    Scanner scanner = new Scanner(System.in);
    private SignUpModel signUpModel;
    public SignUpView(){
        signUpModel = new SignUpModel(this);
    }
    public void getSignUp(){
        System.out.println("Enter UserId : ");
        String userId = scanner.next();
        System.out.println("Enter User Password : ");
        String password = scanner.next();
        System.out.println("Enter User EmailId : ");
        String userEmailId = scanner.next();
        System.out.println("Enter User Phone No : ");
        long userPhoneNo = scanner.nextLong();
        System.out.println("Enter User Address : ");
        String userAddress = scanner.next();
        signUpModel.giveSignUp(userId,password,userEmailId,userAddress,userPhoneNo);
        System.out.println("User Add Successfully Now You can Login");
        HomeView homeView = new HomeView();
        homeView.appStart();
    }
}
