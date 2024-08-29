package com.reservation.web.controller;

import com.reservation.web.model.Station;
import com.reservation.web.services.StationService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

public class StationController extends HttpServlet {


    private final StationService stationServices=new StationService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("Station.html").forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String stationId = request.getParameter("station_id");
        String userId = request.getParameter("user_id");

        Station station=new Station();
        station.setStationId(stationId);
        station.setUserId(userId);

        try{
            boolean isInserted = stationServices.insertStation(station);
            response.setContentType("text/html");
            PrintWriter out=response.getWriter();
            out.println("<html><body>");
            if (isInserted){
                out.println("<h1> Station object inserted to db</h1>");
            }else {
                out.println("<h1>Station object is Not inserted to db</h1>");
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
