package com.akasharavinth.librarymanagement.manageuser;

import com.akasharavinth.librarymanagement.database.DataManagement;
import com.akasharavinth.librarymanagement.home.HomeView;
import com.akasharavinth.librarymanagement.librarysetup.LibrarySetupView;
import com.akasharavinth.librarymanagement.managebooks.ManageBooksView;

import java.sql.DatabaseMetaData;
import java.util.Scanner;

public class ManageUserView {
    Scanner scanner = new Scanner(System.in);
    private ManageUserModel manageUserModel;

    public ManageUserView() {
        manageUserModel = new ManageUserModel(this);
    }

    public void init() {
        System.out.println("You can add,remove,update user Details");
        manageUser();
    }

    public void manageUser() {
        System.out.println("1 --> add User\n2 --> Remove User\n3 -->Update User\n4 --> Show Back\n5 --> LogOut\n6 --> Go Back");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1: {
                getaddUserInfo();
                break;
            }
            case 2: {
                getRemoveUser();
                break;
            }
            case 3: {
                getUpdateUser();
                break;
            }
            case 4: {
                DataManagement.getInstance().showUser();
                manageUser();
                break;
            }
            case 5: {
                HomeView homeView = new HomeView();
                homeView.appStart();
                break;
            }
            case 6 : {
                LibrarySetupView librarySetupView = new LibrarySetupView();
                librarySetupView.init();
            }
            default: {
                System.out.println("Please Enter Valid Choice");
                manageUser();
                break;
            }
        }
    }

    public void getaddUserInfo() {
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
        manageUserModel.giveAddUser(userId, password, userEmailId, userPhoneNo, userAddress);
        addMoreUser();
    }

    public void showAlert(String userAdded_successfully) {
        System.out.println(userAdded_successfully);
    }

    public void getRemoveUser() {
        System.out.println("Enter remove UserId");
        String userId = scanner.next();
        manageUserModel.giveRemoveUserId(userId);
        manageUser();
    }
    public void addMoreUser(){
        System.out.println("Do You Want to add More Books then type yes else type no");
        String choice = scanner.next();
        if (choice.equalsIgnoreCase("yes")){
            getaddUserInfo();
        }else if(choice.equalsIgnoreCase("no")){
            manageUser();
        }else {
            System.out.println("please Enter Valid Choice");
        }
    }

    public void getUpdateUser() {
        System.out.println("You Wants to Give Detais abount update user");
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
        manageUserModel.giveUpdateUser(userId, password, userEmailId, userAddress, userPhoneNo);
        manageUser();
    }
}
