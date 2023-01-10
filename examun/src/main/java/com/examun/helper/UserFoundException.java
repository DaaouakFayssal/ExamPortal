package com.examun.helper;

public class UserFoundException extends  Exception {

    public  UserFoundException(){
        super( "User with this username is already  there in database !!  try with an other one     ");
    }

    public  UserFoundException (String msg ){
        super(msg);
    }
}
