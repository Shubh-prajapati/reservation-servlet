package com.reservation.web.controller;

import com.reservation.web.model.TrainDetails;
import com.reservation.web.services.TrainServices;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

public class TrainController extends HttpServlet {

    private final TrainServices trainService =new TrainServices();

    @Override
    protected  void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        request.getRequestDispatcher("Train.html").forward(request,response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String trainNumber = request.getParameter("trainNumber");
        String sourceStation = request.getParameter("sourceStation");
        String destinationStation = request.getParameter("destinationStation");
        String classType = request.getParameter("classType");
        String currentAvailable = request.getParameter("currentAvailable");


        TrainDetails trainDetails=new TrainDetails();
        trainDetails.setTrainNumber((long)Integer.parseInt(trainNumber));
        trainDetails.setSouceStation(sourceStation);
        trainDetails.setDestination(destinationStation);
        trainDetails.setClassType(classType);
        trainDetails.setCurrentAvailable(currentAvailable);

        try{
            boolean isInserted = trainService.insertTrain_Details();
            response.setContentType("");
            PrintWriter out=response.getWriter();
            out.println("<html><body>");
            if (isInserted){
                out.println("<h1>Train Object Inserted to db</h1>");
            }else {
                out.println("<h1>Train Object in Not insert to db</h1>");
            }
            out.println("</body></html>");
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        request.getRequestDispatcher("").forward(request, response);
    }


    public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        System.out.println("--------------- inside the service() method ---------------");
        if (request.getMethod().equals("POST")) {
            this.doPost(request, response);
        } else {
            this.doGet(request, response);
        }
    }



    public void destroy(){
        System.out.println("-------------- inside the destroy() method----------------");
    }

}
