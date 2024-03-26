package com.akasharavinth.librarymanagement.admin;

public class Validations {
    public boolean userNameValidation(String name){
        if(name.length() < 5)
            return false;
        boolean number = false;
        boolean Upper = false;
        for (int i =0;i<name.length();i++){
            if(Character.isAlphabetic(name.charAt(i))){
                Upper = true;
            }else if(Character.isDigit(name.charAt(i))){
                number = true;
            }
        }
        return number && Upper;
    }
    public boolean passwordValidation(String password){
        if (password.length()<5){
            return false;
        }
        return true;
    }
}
