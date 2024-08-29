package com.reservation.web.controller;

import com.reservation.web.model.PaymentDetails;
import com.reservation.web.services.PaymentDetailsServices;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;


public class PaymentController extends HttpServlet {
    private final PaymentDetailsServices paymentDetailsServices=new PaymentDetailsServices();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("payment.html").forward(request, response);
    }


@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String paymentId = request.getParameter("payment_id");
        String reservationId = request.getParameter("reservation_id");
        String userId = request.getParameter("user_id");
        String userName = request.getParameter("user_Name");
        String amount= request.getParameter("amount");

    PaymentDetails paymentDetails=new PaymentDetails();
        paymentDetails.setPaymentId(paymentId);
        paymentDetails.setReservationId(reservationId);
        paymentDetails.setUserName(userName);
        paymentDetails.setAmount(amount);

    boolean isInserted = false;
    try {
        isInserted = paymentDetailsServices.insertpaymentDetails(paymentDetails);
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }
    response.setContentType("text/html");
    PrintWriter out=response.getWriter();
    out.println("<html><body>");
    if (isInserted){
        out.println("<h1> Users object inserted to db</h1>");
    }else {
        out.println("<h1>Users object is Not inserted to db</h1>");
    }
    out.println("</body></html>");

    request.getRequestDispatcher(" ").forward(request,response);
}
    public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        System.out.println("--------------- inside the service() method ---------------");
        if (request.getMethod().equals("POST")) {
            this.doPost(request, response);
        } else {
            this.doGet(request, response);
        }
    }


}
