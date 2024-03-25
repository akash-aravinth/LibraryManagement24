package com.akasharavinth.librarymanagement.login;

import com.akasharavinth.librarymanagement.database.DataManagement;
import com.akasharavinth.librarymanagement.models.User;

public class SignUpModel {
    private SignUpView signUpView;
    SignUpModel(SignUpView signUpView){
        this.signUpView = signUpView;
    }

    public void giveSignUp(String userId, String password, String userEmailId, String userAddress, long userPhoneNo) {
        User user = new User();
        user.setUserId(userId);
        user.setUserPhoneNo(userPhoneNo);
        user.setUserPassword(password);
        user.setUserEmailId(userEmailId);
        user.setUserAddress(userAddress);
        user.setUserNo();
        DataManagement.getInstance().addUser(user);
    }
}
