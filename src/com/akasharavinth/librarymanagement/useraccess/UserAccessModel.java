package com.akasharavinth.librarymanagement.useraccess;

import com.akasharavinth.librarymanagement.database.DataManagement;
import com.akasharavinth.librarymanagement.models.Book;
import com.akasharavinth.librarymanagement.models.User;

public class UserAccessModel {
    private UserAccessView userAccessView;
    UserAccessModel(UserAccessView userAccessView){
        this.userAccessView = this.userAccessView;
    }
    public void giveJournerBooks(String jorner){
        DataManagement.getInstance().showJournerBooks(jorner);
    }

    public void giveRequestBook(User user, String bookName) {
        Book book = DataManagement.getInstance().getBook(bookName);
        if (book.isBookAvailable()){
            book.decreseBook();
            user.addDueBooks(book.getBookId());
        }else{
            userAccessView.showAlert("Book is Not Available");
            userAccessView.userAccess(user);
        }
    }
}
