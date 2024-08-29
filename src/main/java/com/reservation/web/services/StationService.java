package com.reservation.web.services;

import com.reservation.web.model.Station;
import com.reservation.web.repository.StationRepository;
import java.sql.SQLException;

public class StationService {

    private StationRepository stationRepository=new StationRepository();

    public boolean insertStation(Station station)throws SQLException{
        if(stationRepository.insertStation(station)){
            System.out.println("Station insert successfully!");

        }else{
            System.out.println("Failed to inserted Station");
            return  false;
        }
        return  true;
    }



}
