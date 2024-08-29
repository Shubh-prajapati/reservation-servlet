package com.reservation.web.repository;
import com.reservation.web.model.Station;
import com.reservation.web.services.ConnectionService;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StationRepository {
    private static Connection connection = null;

    private void initConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            connection = new ConnectionService().getConnection();
        }
    }
    public List<Station> retrieveStaion(){
        List<Station> station=new ArrayList<>();
        // Use the connection to execute SQL queries and interact with the database

        try {
            this.initConnection();

            //Your database query operation here........
            Statement statement=connection.createStatement();
            ResultSet resultSet=statement.executeQuery("Select * from Station");


            //Iterate over the result set
            while (resultSet.next()){
                int station_id=resultSet.getInt("station_id");
                int user_id=resultSet.getInt("user_id");

                // Do something with the data print it
                Station station1=new Station();
                station.add(station1);
            }

            }catch (SQLException e){
            System.err.println("SQL err:"+e.getMessage());
        } finally {
            if(connection !=null){
                try {
                    connection.close();

                }catch (SQLException e){
                    System.err.println("Error closing connection: "+e.getMessage());
                }
            }
        }
        return  station;
    }
    // Method to insert station data into database
    public boolean insertStation(Station station) throws SQLException{
        this.initConnection();

        String query="INSERT INTO Station VALUES (?,?)";
        try (PreparedStatement preparedStatement=connection.prepareStatement(query)){

            preparedStatement.setInt(1, station.getStationId());
            preparedStatement.setInt(2, station.getUserId());


            System.out.println("inserting station details into Station table: "+ station);
            int rowInserted =preparedStatement.executeUpdate();

            return rowInserted>0 ;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return  false;
    }

    // Method to update user data into database
    public boolean updateStation(Station station)throws  SQLException{
        this.initConnection();
        String query="UPDATE station SET station_id= ?";
        try(PreparedStatement preparedStatement=connection.prepareStatement(query)){

            preparedStatement.setInt(1,station.getStationId());
            preparedStatement.setInt(2,station.getUserId());

            System.out.println("Inserting details of station into Station table: "+station);
            int rowInserted =preparedStatement.executeUpdate();

        return rowInserted>0;

        }catch (SQLException e){
            e.printStackTrace();
        }
        return  false;

    }
// Method to delete station details from database
    public boolean deleteStation(int station_id) throws  SQLException{
        this.initConnection();

        String query="DELETE FROM station WHERE station_id= ?";
        try(PreparedStatement preparedStatement=connection.prepareStatement(query)){
            preparedStatement.setInt(1,station_id);
            System.out.println("Deleting station Details from the station table: "+station_id);
            int rowInserted =preparedStatement.executeUpdate();

        return rowInserted>0;
        }catch (SQLException e){
            e.printStackTrace();
        }
    return false;
    }

}
