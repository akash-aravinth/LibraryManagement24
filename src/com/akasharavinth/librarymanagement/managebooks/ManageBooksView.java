package com.akasharavinth.librarymanagement.managebooks;

import com.akasharavinth.librarymanagement.database.DataManagement;
import com.akasharavinth.librarymanagement.librarysetup.LibrarySetupView;
import com.akasharavinth.librarymanagement.models.Book;
import com.akasharavinth.librarymanagement.models.Library;

import java.util.List;
import java.util.Scanner;

public class ManageBooksView {
    Scanner scanner = new Scanner(System.in);
    private ManageBookModel manageBookModel;
    public ManageBooksView(){
        manageBookModel = new ManageBookModel(this);
    }
    public void init(){
        System.out.println("Here You Can Add New Book, Remove Book, UpdateBook, Search Book, Show All Books");
        manageBook();
    }
    public void manageBook(){
        System.out.println("1 --> Add New Book\n2 --> Remove Book\n3 --> UpdateBook\n4 --> SearchBook\n5 --> Show Books\n6 --> Go Back");
        int choice = scanner.nextInt();
        switch (choice){
            case 1 : {
                getBookInfo();
                break;
            }
            case 2 : {
                removeBookInfo();
                break;
            }
            case 3 : {
                getUpdateBook();
                break;
            }
            case 4 : {
                searchBook();
                manageBook();
                break;
            }
            case 5 :{
                DataManagement.getInstance().showBook();
                manageBook();
                break;
            }
            case 6 :{
                LibrarySetupView librarySetupView = new LibrarySetupView();
                librarySetupView.init();
            }
            default:{
                System.out.println("Please Enter Valid Choice ");
                manageBook();
            }
        }
    }

    public void searchBook(){
        System.out.println("Enter BookName Please Mention 3 Characters");
        String bookName = scanner.next();
        List<Book> searchBookList = manageBookModel.getSearchBook(bookName);
        for (Book b : searchBookList){
            System.out.println("Book Name : "+b.getBookName()+" BookId "+b.getBookId()+" BookAuthor : "+b.getBookAuthor());
        }
    }
    public void getBookInfo(){
        Book book = new Book();
        System.out.println("Enter Book Name");
        book.setBookName(scanner.next());
        System.out.println("Enter Book Author");
        book.setBookAuthor(scanner.next());
        System.out.println("Enter No Of Books");
        book.setNoOfBooks(scanner.nextInt());
        System.out.println("Enter Book Publication");
        book.setBookPublication(scanner.next());
        System.out.println("Enter book Journer");
        book.setBookJourner(scanner.next());
        book.setBookId();
        manageBookModel.giveBookInfo(book);
        addMoreBook();
    }
    public void removeBookInfo(){
        System.out.println("Enter Remove Book Id");
        long bookId = scanner.nextLong();
        manageBookModel.giveRemoveBook(bookId);
        System.out.println("Book Deleted Successfully");
        manageBook();
    }
    public void addMoreBook(){
        System.out.println("Do You Want to add More Books then type yes else type no");
        String choice = scanner.next();
        if (choice.equalsIgnoreCase("yes")){
            getBookInfo();
        }else if(choice.equalsIgnoreCase("no")){
            manageBook();
        }else {
            System.out.println("please Enter Valid Choice");
        }
    }
    public void getUpdateBook(){
        System.out.println("Enter Book Id");
        long bookId = scanner.nextLong();
        System.out.println("Enter BookName");
        String bookName = scanner.next();
        System.out.println("Enter Book Author");
        String bookAuthor = scanner.next();
        System.out.println("Enter Book Publication");
        String bookPublication = scanner.next();
        System.out.println("Enter no Of Books");
        int noOfBook = scanner.nextInt();
        System.out.println("Enter Book Journer");
        String bookJourner = scanner.next();
        manageBookModel.giveupdateBook(bookId,bookName,bookAuthor,bookJourner,bookPublication,noOfBook);
        manageBook();
    }

    public void showAlert(String update_book_successfully) {
        System.out.println(update_book_successfully);
        manageBook();
    }

}
