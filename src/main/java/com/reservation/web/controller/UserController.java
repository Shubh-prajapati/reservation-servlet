package com.reservation.web.controller;

import com.reservation.web.model.Users;
import com.reservation.web.services.UserServices;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

public class UserController extends HttpServlet {

        private final UserServices userServices=new UserServices();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("User.html").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userId = request.getParameter("userId");
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String  mobileNo = request.getParameter("mobileNo");
        String address = request.getParameter("address");

        Users users=new Users();
        users.setUserId(userId);
        users.setName(name);
        users.setEmail(email);
        users.setMobileNo(mobileNo);
        users.setAddress(address);

        try{
            boolean isInserted = userServices.insertUser(users);
            response.setContentType("text/html");
            PrintWriter out=response.getWriter();
            out.println("<html><body>");
            if (isInserted){
                out.println("<h1> Users object inserted to db</h1>");
            }else {
                out.println("<h1>Users object is Not inserted to db</h1>");
            }
            out.println("</body></html>");

        }catch (SQLException e){
            throw new RuntimeException(e);
        }

        request.getRequestDispatcher("").forward(request,response);
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
        System.out.println("---------------inside the destroy() method------------------");

    }

}
