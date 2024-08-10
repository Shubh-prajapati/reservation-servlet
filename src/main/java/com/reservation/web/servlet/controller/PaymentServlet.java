package com.reservation.web.servlet.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class PaymentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String paymentId = request.getParameter("payment_id");
        String reservationId = request.getParameter("reservation_id");
        String userId = request.getParameter("user_id");
        String userName = request.getParameter("user_Name");
        String amount= request.getParameter("amount");


        // Process the data (e.g., save to database)
        // ...

        response.getWriter().println("Payment submitted successfully!");
    }
}
