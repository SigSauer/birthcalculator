package com.sigsauer.univ.birthcalculator.exception;

public class UserAlreadyExistException extends UserException{

    UserAlreadyExistException(String message) {
        super(message);
    }

    public UserAlreadyExistException(String field, String value) {
        super("User with "+ field +"="+ value +" already exist");
    }
}
