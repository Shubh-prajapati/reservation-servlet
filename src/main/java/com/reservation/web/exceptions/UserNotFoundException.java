package com.reservation.web.exceptions;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(int userId){
        super("User Not Found with Id: "+userId);
    }
}
