package com.exam.helper;

public class UserFoundException extends Exception{
    public UserFoundException(){
        super("User with the username is already present! try with another one");
    }
    public UserFoundException(String msg){
        super(msg);
    }
}
