package com.reservation.web.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class IndexServlet extends HttpServlet {

    public void init()throws  SecurityException{

    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Handle GET request
        response.setContentType("text/html");
        response.getWriter().println("<html><body>");
        response.getWriter().println("<h1>Welcome to the Train Reservation Management</h1>");
        response.getWriter().println("<p>Select a form to manage the respective entity:</p>");
        response.getWriter().println("<ul>");
        response.getWriter().println("<li><a href='user.html'>User From</a></li>");
        response.getWriter().println("<li><a href='station.html'>Station Form</a></li>");
        response.getWriter().println("<li><a href=''>Reservation  Form</a></li>");
        response.getWriter().println("<li><a href='payment.html'>Payment Form</a></li>");
        response.getWriter().println("<li><a href='train.html'>Train Form</a></li>");
        response.getWriter().println("</ul>");
        response.getWriter().println("</body></html>");
    }

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.service(request, response);
        // Service method code
    }




}
