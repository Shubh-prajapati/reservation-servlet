package com.reservation.web.servlet.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class StationServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String stationId = request.getParameter("station_id");
        String userId = request.getParameter("user_id");


        // Process the data (e.g., save to database)

        response.getWriter().println("Station submitted successfully!");
    }



}
