package com.reservation.web.model;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class PaymentDetails {

    private int paymentId;
    private long reservationId;
    private  String userName;
    private  double amount;

}
