package com.reservation.web.services;


import com.reservation.web.model.PaymentDetails;
import com.reservation.web.repository.PaymentDetailsRepository;

import java.sql.SQLException;


public class PaymentDetailsServices {
    private static PaymentDetailsRepository paymentDetailsRepository = new PaymentDetailsRepository();

    public boolean insertpaymentDetails(PaymentDetails paymentDetails) throws SQLException{
        if (paymentDetailsRepository.insertPayment_Details(paymentDetails)){
            System.out.println("Payment Details inserted succesfully ");
        }else{
            System.out.println("Failed to insert Payment Details ");
            return false;
        }
        return true;
    }
}
