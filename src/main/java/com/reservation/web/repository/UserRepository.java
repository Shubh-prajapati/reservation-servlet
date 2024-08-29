package com.reservation.web.repository;

import com.reservation.web.model.Users;
import com.reservation.web.services.ConnectionService;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class UserRepository {

    private static Connection connection = null;

    private void initConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            connection = new ConnectionService().getConnection();
        }
    }
       public List<Users> retrieveUser(){
        List<Users> users = new ArrayList<>();
           //Use the Connection to execute SQL queries and interact with the database
           try{
               this.initConnection();

               //Your database query Operation here....
               Statement statement = connection.createStatement();
               ResultSet resultSet = statement.executeQuery("Select * from user");


               // Iterate over the result set
               while (resultSet.next()){
                   int user_id=resultSet.getInt("id");
                   String name=resultSet.getString("name");
                   String email=resultSet.getString("email");
                   long mobile_no=resultSet.getLong("mobile_no");
                   String address=resultSet.getString("address");

                   //Do something with the data print it

                   Users users1 = new Users(user_id,name,email,mobile_no,address);
                   users.add(users1);

               }

           }catch (SQLException e){
               System.err.println("SQL err: "+ e.getMessage());
           }finally {
               //close the connection here
               if(connection !=null){
                   try {
                       connection.close();
                   }catch (SQLException e){
                       System.err.println("Error closing connection: "+e.getMessage());
                   }
               }
       }
        return users;
    }

    //Method to insert user data into database
    public boolean insertUser(Users users) throws SQLException {
        this.initConnection();

        String query = "INSERT INTO user VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, users.getUserId());
            preparedStatement.setString(2, users.getEmail);
            preparedStatement.setString(3, users.getName);
            preparedStatement.setLong(4, users.getMobileNo());
            preparedStatement.setString(5, users.getAddress());


            System.out.println("inserting details of User into User table: " + users);

            int rowsInserted = preparedStatement.executeUpdate();

            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    //Method to update user data into the database.....
    public boolean updateUser(Users users)throws SQLException{
        this.initConnection();
        String query =" UPDATE user SET user_id= ?, name= ?, email = ?, mobile_id = ? address = ? WHERE ID=? ";
        try(PreparedStatement preparedStatement=connection.prepareStatement(query)){


            preparedStatement.setInt(1, users.getUserId());
            preparedStatement.setString(2, users.getName());
            preparedStatement.setString(3, users.getEmail());
            preparedStatement.setLong(4, users.getMobileNo());
            preparedStatement.setString(5, users.getAddress());

            System.out.println("Updating user of details to user Table:  "+ users);
            int rowInserted = preparedStatement.executeUpdate();

            return rowInserted> 0;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return  false;
    }
    // Method to delete user data from database............
    public boolean deleteUser(Integer user_id) throws SQLException{
        this.initConnection();

        String query="DELETE FROM user WHERE user_id= ?";
        try(PreparedStatement preparedStatement =connection.prepareStatement(query)){
            preparedStatement.setLong(1, user_id);
            System.out.println("Deleting user details from the User Table: "+user_id);
            int rowInserted = preparedStatement.executeUpdate();

            return rowInserted>0;

        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }
}


