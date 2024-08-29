package com.reservation.web.exceptions;

public class ReservationNotFoundException extends RuntimeException {
    public ReservationNotFoundException(int reservationId){
        super("Reservation not found with reservationId :"+reservationId);
    }
}
