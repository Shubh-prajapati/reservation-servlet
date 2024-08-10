package com.reservation.web.servlet.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class TrainServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String trainNumber = request.getParameter("trainNumber");
        String sourceStation = request.getParameter("sourceStation");
        String destinationStation = request.getParameter("destinationStation");
        String classType = request.getParameter("classType");
        String currentAvailable = request.getParameter("currentAvailable");

        // Process the data (e.g., save to database)
        // ...

        response.getWriter().println("Train submitted successfully!");
    }



    public void destroy(){
        super.destroy();
    }

}
