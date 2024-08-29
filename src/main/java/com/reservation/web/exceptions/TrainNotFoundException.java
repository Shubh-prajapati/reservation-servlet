package com.reservation.web.exceptions;

public class TrainNotFoundException extends RuntimeException{
    public  TrainNotFoundException(int trainNumber){
        super("Train Number Not Found :"+trainNumber);
    }
}
