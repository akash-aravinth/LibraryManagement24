package com.akasharavinth.librarymanagement.managebooks;

import com.akasharavinth.librarymanagement.database.DataManagement;
import com.akasharavinth.librarymanagement.models.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ManageBookModel {
    Scanner scanner = new Scanner(System.in);
    private ManageBooksView manageBooksView;
    ManageBookModel(ManageBooksView manageBooksView){
        this.manageBooksView = manageBooksView;
    }

    public void giveBookInfo(Book book) {
        //validate
        DataManagement.getInstance().addBook(book);
    }

    public Book getUpdateBook(long bookId) {
        //you want to check Book exists or not
        for(Book b : DataManagement.getInstance().getBookList()){
            if(b.getBookId() == bookId){
                return b;
            }
        }
        return null;
    }


    public void giveupdateBook(long bookId, String bookName, String bookAuthor, String bookJourner, String bookPublication, int noOfBook) {
        Book book = getUpdateBook(bookId);
        book.setBookName(bookName);
        book.setBookAuthor(bookAuthor);
        book.setBookPublication(bookPublication);
        book.setBookJourner(bookJourner);
        book.setNoOfBooks(noOfBook);
        manageBooksView.showAlert("Update Book Successfully");
    }

    public void giveRemoveBook(long bookId) {
        DataManagement.getInstance().removeBook(bookId);
    }

    public List<Book> getSearchBook(String bookName) {
        List<Book> books = new ArrayList<>();
        for (Book b : DataManagement.getInstance().getBookList()){
            if (b.getBookName().contains(bookName)){
                books.add(b);
            }
        }
        return books;
    }
}
