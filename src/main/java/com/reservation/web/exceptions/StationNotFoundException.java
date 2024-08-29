package com.reservation.web.exceptions;

public class StationNotFoundException  extends RuntimeException{
    public StationNotFoundException(int stationId){
        super("Super not found with station id: "+stationId);
    }
}
