package Servlet;

import Model.PrepareOrder;
import Service.SQLControl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class CheckOutServlet extends javax.servlet.http.HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String order = req.getParameter("t");
        System.out.println(order);
        SQLControl control = new SQLControl();
        control.updateStatus(order,"deliver","paid");
        resp.sendRedirect("CheckOut.jsp");


    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        request.setAttribute("name", name);
        response.sendRedirect("print.jsp");


        doGet(request,response);
    }
}
