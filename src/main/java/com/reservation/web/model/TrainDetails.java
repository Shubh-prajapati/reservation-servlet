package com.reservation.web.model;


import lombok.*;
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Setter
public class TrainDetails {

    private  int trainNumber;
    private  String sourceStation;
    private String destinationStation;
    private String classType;
    private int currentAvailable;


}
