package com.reservation.web.repository;

import com.reservation.web.model.Reservation;
import com.reservation.web.services.ConnectionService;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReservationRepository {
    private static Connection connection = null;
    private void initConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            connection = new ConnectionService().getConnection();
        }
    }

    public List<Reservation> retrieveReservation() {
        List<Reservation> reservation = new ArrayList<>();

        //Use the connection to execute SQL queries and interact with database
        try {
            this.initConnection();

            //Your database query Operation here.......
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM RESERVATION");


            //Iterator over the result set
            while (resultSet.next()) {
                long reservationId = resultSet.getLong("reservationId");
                int trainNumber = resultSet.getInt("trainNumber");
                int userId = resultSet.getInt("userId");
                String classType = resultSet.getString("classType");
                long pnrNo = resultSet.getLong("pnrNo");
                int journeyDate = resultSet.getInt("journeyDate");

                //Do something with the data print it

                Reservation reservation1 = new Reservation();
                reservation.add(reservation1);
            }


        } catch (SQLException e) {
            System.err.println("SQL err: " + e.getMessage());
        } finally {
            //close the connection here
            if (connection != null) {
                try {
                    connection.close();

                } catch (SQLException e) {
                    System.err.println("Error closing connection: " + e.getMessage());
                }
            }
        }
        return reservation;
    }


    //Method to insert user data into Database

    public boolean insertReservation(Reservation reservation) throws SQLException {
        this.initConnection();
        String query = "INSERT INTO reservation (reservationId, trainNumber, userId, classType, pnrNo, journeyDate) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setLong(1, reservation.getReservationId());
            preparedStatement.setInt(2, reservation.getTrainNumber());
            preparedStatement.setInt(3, reservation.getUserId());
            preparedStatement.setString(4, reservation.getClassType());
            preparedStatement.setLong(5, reservation.getPnrNo());
            preparedStatement.setInt(6, reservation.getJourneyDate());

            System.out.println("Update reservation details to reservation table: " + reservation);
            int rowInserted = preparedStatement.executeUpdate();

            return rowInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

// Method to delete user data from database

    public boolean deleteReservation(long reservation_id) throws SQLException {
        this.initConnection();

        String query = "DELETE FROM reservation WHERE reservation_id = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setLong(1, reservation_id);
            System.out.println("Deleting reservation from the Reservation Table: " + reservation_id);
            int rowInserted = preparedStatement.executeUpdate();

            return rowInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


}
