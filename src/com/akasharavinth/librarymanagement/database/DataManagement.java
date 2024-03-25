package com.akasharavinth.librarymanagement.database;

import com.akasharavinth.librarymanagement.models.Admin;
import com.akasharavinth.librarymanagement.models.Book;
import com.akasharavinth.librarymanagement.models.Library;
import com.akasharavinth.librarymanagement.models.User;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;

public class DataManagement {
    private static DataManagement dataManagement;

    public static DataManagement getInstance() {
        if (dataManagement == null)
            dataManagement = new DataManagement();
        return dataManagement;
    }
    List<Admin> adminList = new ArrayList<>();
    public void addAdmin(Admin a) {
        adminList.add(a);
    }

    public List<Admin> getAdminList() {
        return adminList;
    }

    private Library library;
    public Library insertLibrary(Library library2) {
        this.library = library2;
        this.library.setLibraryId(1);
        return library;
    }

    //---------------------------------Book Based Data-----------------------------------

    List<Book> bookList = new ArrayList<>();

    public List<Book> getBookList() {
        return bookList;
    }

    public void addBook(Book b){
        bookList.add(b);
    }
    public void showBook(){
        for (Book b : bookList){
            System.out.println(b.getBookId()+"  "+b.getBookName()+"  "+b.getBookAuthor());
        }
    }
    public void removeBook(long bookId){
        for (Book b : bookList){
            if(b.getBookId() == bookId){
                bookList.remove(b);
            }
        }
    }
    public void removeNoOfBook(long bookId,int noOfBook){
        for(Book b : bookList){
            if (b.getBookId() == bookId){
                b.setNoOfBooks(noOfBook);
            }
        }
    }

    //-----------------------------User Details---------------------------------------

    List<User> userList = new ArrayList<>();

    public List<User> getUserList() {
        return userList;
    }
    public void addUser(User u){
        userList.add(u);
    }
    public void removeUser(String userId){
        for(User u : userList){
            if(u.getUserId().equals(userId)){
                userList.remove(u);
            }
        }
    }
    public void showUser(){
        for (User u : userList){
            System.out.println(u.getUserNo()+" "+u.getUserId()+" "+u.getUserPassword());
        }
    }
    public User getUser(String userId){
        for(User u : userList){
            if(u.getUserId().equals(userId)){
                return u;
            }
        }
        return null;
    }

    public void showJournerBooks(String jorner) {
        for (Book b : bookList){
            if (b.getBookJourner().equals(jorner)){
                System.out.println(b.getBookId()+"  "+b.getBookName());
            }
        }
    }

    public Book getBook(String bookName) {
        for (Book b : bookList){
            if(b.getBookName().equals(bookName))
                return b;
        }
        return null;
    }
}
