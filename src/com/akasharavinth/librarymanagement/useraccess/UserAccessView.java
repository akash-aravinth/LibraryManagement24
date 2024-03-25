package com.akasharavinth.librarymanagement.useraccess;

import com.akasharavinth.librarymanagement.LibraryManagement;
import com.akasharavinth.librarymanagement.database.DataManagement;
import com.akasharavinth.librarymanagement.models.User;

import java.util.Scanner;

public class UserAccessView {
    private UserAccessModel userAccessModel;
    Scanner scanner = new Scanner(System.in);
    public UserAccessView(){
        userAccessModel = new UserAccessModel(this);
    }
    public void init(User user){
        System.out.println("Welcome To : "+ LibraryManagement.getInstance().getAppName()+" and the Version : "+LibraryManagement.getInstance().getAppVersion());
        userAccess(user);
    }
    public void userAccess(User user){
        System.out.println("1 --> Show All Books\n2 --> Show JournerType Book\n3 --> Get a Book\n4 --> Go Back");
        int choice = scanner.nextInt();
        switch (choice){
            case 1 : {
                DataManagement.getInstance().showBook();
                break;
            }
            case 2 : {
                getJournerBooks();
                userAccess(user);
                break;
            }
            case 3 : {
                getRequestBook(user);
                break;
            }
            case 4 : {
                System.out.println("Go Back");
                break;
            }
            default:{
                System.out.println("Enter Valid Choice");
                userAccess(user);
            }
        }
    }
    public void getJournerBooks(){
        System.out.println("Enter the Journer");
        String journer = scanner.next();
        userAccessModel.giveJournerBooks(journer);
    }
    public void getRequestBook(User user){
        System.out.println("Enter Book Name");
        String bookName = scanner.next();
        userAccessModel.giveRequestBook(user,bookName);
    }

    public void showAlert(String book_is_not_available) {
        System.out.println(book_is_not_available);
    }
}
