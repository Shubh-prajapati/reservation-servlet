package com.reservation.web.exceptions;

public class PaymentDetailsNotFoundException extends RuntimeException {
    public  PaymentDetailsNotFoundException(int paymentId){
        super("Payment Details Not Found with paymentId "+paymentId);
    }
}
