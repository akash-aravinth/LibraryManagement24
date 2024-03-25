package com.akasharavinth.librarymanagement.models;

import com.akasharavinth.librarymanagement.database.DataManagement;

public class Book {
    private static long bookCount = DataManagement.getInstance().getBookList().size();
    private String bookName;
    private String bookAuthor;
    private long bookId;
    private int noOfBooks;
    private String bookJourner;
    private String bookPublication;

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public long getBookId() {
        return bookId;
    }

    public void setBookId() {
        this.bookId = bookCount++;
    }

    public int getNoOfBooks() {
        return noOfBooks;
    }

    public void setNoOfBooks(int noOfBooks) {
        this.noOfBooks = noOfBooks;
    }

    public boolean isBookAvailable() {
        if (noOfBooks > 0)
            return true;
        return false;
    }

    public void decreseBook() {
        noOfBooks = noOfBooks - 1;
    }

    public String getBookJourner() {
        return bookJourner;
    }

    public void setBookJourner(String bookJourner) {
        this.bookJourner = bookJourner;
    }

    public String getBookPublication() {
        return bookPublication;
    }

    public void setBookPublication(String bookPublication) {
        this.bookPublication = bookPublication;
    }
}
