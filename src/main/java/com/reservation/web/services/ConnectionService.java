package com.reservation.web.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionService {
    public Connection getConnection() {

        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url="jdbc:mysql://localhost:3306/reservationdb";
            String username="root";
            String password="shubh@3098";
            connection = DriverManager.getConnection(url ,username, password);
        }catch (SQLException e){
            System.err.println("Connection error: "+e.getMessage());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return connection;




    }
}
