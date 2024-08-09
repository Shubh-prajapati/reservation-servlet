package com.reservation.web.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class ReservationServlet  extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String reservationId = request.getParameter("reservation_Id");
        String trainNumber = request.getParameter("train_Number");
        String userId = request.getParameter("user_id");
        String classtype=request.getParameter("class_Type");
        String pntNo=request.getParameter("pnr_no");
        String journeyDate=request.getParameter("journey_Date");


        // Process the data (e.g., save to database)..............


        response.getWriter().println("Reservation submitted successfully!");
    }

}
