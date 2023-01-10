package com.examun.helper;

public class UserNotFoundException  extends  Exception{
    public UserNotFoundException(){
        super("User whid this username is  not found in database !! ");
    }

    public  UserNotFoundException(String msg){
        super(msg);
    }
}
