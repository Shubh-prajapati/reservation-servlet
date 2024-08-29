package com.reservation.web.services;


import com.reservation.web.repository.TrainDetailsRepository;

import java.sql.SQLException;

public class TrainServices {

    private TrainDetailsRepository trainDetailsRepository=new TrainDetailsRepository();

    public boolean insertTrain_DetailsRepository(TrainDetailsRepository trainDetailsRepository)throws SQLException{
        if (trainDetailsRepository.insertTrain_Details(trainDetailsRepository)){
            System.out.println("Train Details Inserted successfully! ");

        }else{
            System.out.println("Failed to inserted Train Details");
            return false;

        }
            return true;
    }



}



