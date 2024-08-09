package com.reservation.web.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class UserServlet extends HttpServlet {

    public void init() throws ServletException{
        super.init();
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userId = request.getParameter("userId");
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String  mobileNo = request.getParameter("mobileNo");
        String address = request.getParameter("address");

        // Process the data (e.g., save to database)
        // ...

        response.getWriter().println("User Details submitted successfully!");
    }

    public void destroy(){
        super.destroy();
    }

}
