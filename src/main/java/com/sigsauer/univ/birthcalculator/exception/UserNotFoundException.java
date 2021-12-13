package com.sigsauer.univ.birthcalculator.exception;

public class UserNotFoundException extends UserException{

    UserNotFoundException(String message) {
        super("UserNotFoundException. "+ message);
    }

    public UserNotFoundException(String field, String value) {
        super("User with "+ field +"="+ value +" cannot be found");
    }
}
