package com.akasharavinth.librarymanagement.librarysetup;

import com.akasharavinth.librarymanagement.database.DataManagement;
import com.akasharavinth.librarymanagement.home.HomeView;
import com.akasharavinth.librarymanagement.login.LoginView;
import com.akasharavinth.librarymanagement.managebooks.ManageBooksView;
import com.akasharavinth.librarymanagement.manageuser.ManageUserView;
import com.akasharavinth.librarymanagement.models.Library;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.sql.DatabaseMetaData;
import java.util.Scanner;

public class LibrarySetupView  {
    private LibrarySetupModel librarySetupModel;
    Scanner scanner = new Scanner(System.in);

    public LibrarySetupView() {
        librarySetupModel = new LibrarySetupModel(this);
    }

    public void init() {
        librarySetupModel.startSetup();
    }

    public void initiateSetup() {
        long libraryId = 0;
        System.out.println("Enter LibraryName : ");
        String libraryName = scanner.next();
        System.out.println("Enter Library Phone No : ");
       try{
           libraryId = scanner.nextLong();
       }catch (Exception e){
           showAlert("Please Enter Valid Moblie No : ");
           initiateSetup();
       }
        System.out.println("Enter Library MailId : ");
        String emailID = scanner.next();
        System.out.println("Enter Library Address : ");
        String address = scanner.next();
        librarySetupModel.createLibrary(libraryName,libraryId,emailID,address);

    }

    public void showAlert(String alert) {
        System.out.println(alert);
    }

    public void onSetupComplete(Library library){
        System.out.println("Welcome To : " + library.getLibraryName());
        System.out.println("1 --> Manage Books\n2 --> Manage User\n3 --> Search Book\n4 --> Logout\n5 --> Go Back");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1: {
                ManageBooksView manageBooksView = new ManageBooksView();
                manageBooksView.init();
                break;
            }
            case 2: {
                ManageUserView manageUserView = new ManageUserView();
                manageUserView.init();
                break;
            }
            case 3: {
                ManageBooksView manageBooksView = new ManageBooksView();
                manageBooksView.searchBook();
                break;
            }
            case 4: {
                System.out.println("Logout Successfully");
                HomeView homeView = new HomeView();
                homeView.appStart();
                break;
            }
            case 5: {
                HomeView homeView = new HomeView();
                homeView.appStart();
                break;
            }
            default: {
                System.out.println("Please Enter Valid Choice");
                onSetupComplete(library);
                break;
            }
        }
    }
}
