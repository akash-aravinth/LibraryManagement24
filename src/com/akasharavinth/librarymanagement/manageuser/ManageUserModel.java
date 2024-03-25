package com.akasharavinth.librarymanagement.manageuser;

import com.akasharavinth.librarymanagement.database.DataManagement;
import com.akasharavinth.librarymanagement.managebooks.ManageBookModel;
import com.akasharavinth.librarymanagement.models.User;

public class ManageUserModel {
    private ManageUserView manageUserView;
    ManageUserModel(ManageUserView manageUserView){
        this.manageUserView = manageUserView;
    }

    public void giveAddUser(String userId, String password, String userEmailId, long userPhoneNo, String userAddress) {
       User user = new User();
       user.setUserId(userId);
       user.setUserPassword(password);
       user.setUserEmailId(userEmailId);
       user.setUserPhoneNo(userPhoneNo);
       user.setUserAddress(userAddress);
       user.setUserNo();
       DataManagement.getInstance().addUser(user);
       manageUserView.showAlert("UserAdded Successfully");
    }

    public void giveRemoveUserId(String userId) {
        DataManagement.getInstance().removeUser(userId);
    }
    public void giveUpdateUser(String userId,String password, String userEmailId,String userAddress,long userPhoneNo){
        //isExists
        User user = DataManagement.getInstance().getUser(userId);
        user.setUserAddress(userAddress);
        user.setUserEmailId(userEmailId);
        user.setUserPassword(password);
        user.setUserPhoneNo(userPhoneNo);
        user.setUserId(userId);
        manageUserView.showAlert("User Update Successfully");
    }
}
