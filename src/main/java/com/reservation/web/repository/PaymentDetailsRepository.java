package com.reservation.web.repository;


import com.reservation.web.model.PaymentDetails;
import com.reservation.web.services.ConnectionService;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PaymentDetailsRepository {
    private static Connection connection = null;

    private void initConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            connection = new ConnectionService().getConnection();
        }
    }
    public List<PaymentDetails> retrievePayment_Details() throws SQLException {

        List<PaymentDetails>paymentDetails =new ArrayList<>();
            //use the connection to execute  SQL queries and interact with the database

             try{
                this.initConnection();

                //Your database query Operation here....
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("Select * from payment");


                //Iterate over the result set
                while (resultSet.next()){
                    int paymentId=resultSet.getInt("payment_details");
                    long reservation=resultSet.getLong("reservation_id");
                    String user_name=resultSet.getString("user_name");
                    double amount=resultSet.getDouble("amount");

                }
            }catch(SQLException e){
                System.err.println("SQL err: "+ e.getMessage());
            }finally {
                 //close the connection here

                 if (connection != null) {
                     try {
                         connection.close();
                     } catch (SQLException e) {
                         System.err.println("Error closing connection: " + e.getMessage());
                     }
                 }
             }
        return  paymentDetails;
    }

    //Method to insert payment details data into database

    public  boolean insertPayment_Details(PaymentDetails paymentDetails)throws SQLException{
     this.initConnection();
     String query="INSERT INTO payment(?,?,?,?)";
     try(PreparedStatement preparedStatement=connection.prepareStatement(query)){

         preparedStatement.setLong(1,paymentDetails.getPaymentId());
         preparedStatement.setLong(2,paymentDetails.getReservationId());
         preparedStatement.setString(3,paymentDetails.getUserName());
         preparedStatement.setDouble(4,paymentDetails.getAmount());


         System.out.println("Inserting payment object into payment table");
         int rowInserted=preparedStatement.executeUpdate();

         return  rowInserted>0;
     }catch (SQLException e){
         e.printStackTrace();
     }
     return false;
    }
}
