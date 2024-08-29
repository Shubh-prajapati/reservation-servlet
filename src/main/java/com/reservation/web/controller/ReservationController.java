package com.reservation.web.controller;

import com.reservation.web.model.Reservation;
import com.reservation.web.services.ReservationServices;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

public class ReservationController extends HttpServlet {

    private final ReservationServices reservationServices=new ReservationServices();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("Reservation.html").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String reservationId = request.getParameter("reservation_Id");
        String trainNumber = request.getParameter("train_Number");
        String userId = request.getParameter("user_id");
        String classtype=request.getParameter("class_Type");
        String pnrNo=request.getParameter("pnr_no");
        String journeyDate=request.getParameter("journey_Date");

        Reservation reservation=new Reservation();
        reservation.setreservationId(reservationId);
        reservation.setTrainNumber(trainNumber);
        reservation.setUserId(userId);
        reservation.setClassType(classtype);
        reservation.setPnrNo(pnrNo);
        reservation.setJourneyDate(journeyDate);

        try{
            boolean isInserted = reservationServices.insertReservation(reservation);
            response.setContentType("text/html");
            PrintWriter out=response.getWriter();
            out.println("<html><body>");
            if (isInserted){
                out.println("<h1> Users object inserted to db</h1>");
            }else {
                out.println("<h1>Users object is Not inserted to db</h1>");
            }
            out.println("</body></html>");

        }catch (
                SQLException e){
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
