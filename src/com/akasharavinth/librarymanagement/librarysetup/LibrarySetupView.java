package com.akasharavinth.librarymanagement.librarysetup;

import com.akasharavinth.librarymanagement.database.DataManagement;
import com.akasharavinth.librarymanagement.home.HomeView;
import com.akasharavinth.librarymanagement.login.LoginView;
import com.akasharavinth.librarymanagement.managebooks.ManageBooksView;
import com.akasharavinth.librarymanagement.manageuser.ManageUserView;
import com.akasharavinth.librarymanagement.models.Library;

import java.sql.DatabaseMetaData;
import java.util.Scanner;

public class LibrarySetupView {
    private LibrarySetupModel librarySetupModel;
    Scanner scanner = new Scanner(System.in);

    public LibrarySetupView() {
        librarySetupModel = new LibrarySetupModel(this);
    }

    public void init() {
        librarySetupModel.startSetup();
    }

    public void initiateSetup() {
        Library library = new Library();
        System.out.println("Enter LibraryName : ");
        library.setLibraryName(scanner.next());
        System.out.println("Enter Library Phone No : ");
        library.setLibraryPhoneNo(scanner.nextLong());
        System.out.println("Enter Library MailId : ");
        library.setLibraryEmailId(scanner.next());
        System.out.println("Enter Library Address : ");
        library.setLibraryAddress(scanner.next());
        librarySetupModel.setInitalValues(library);
    }

    public void showAlert(String alert) {
        System.out.println(alert);
    }

    public void onSetupComplete(Library library) {
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
