package com.reservation.web.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Users {
    private int userId;
    private String name;
    private String email;
    private long mobileNo;
    private String address;


}
