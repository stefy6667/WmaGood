package Servlet;

import Service.SQLControl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

public class HomeServlet extends javax.servlet.http.HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {

        response.setContentType("text/html;charset=UTF-8");


//        HttpSession sesion = request.(true);
//        String name = (String) sesion.getAttribute("name");
//        sesion.setAttribute("name",name);
//        System.out.println(name);


        String id = request.getParameter("id");
        String collumn = request.getParameter("column");
        String result = request.getParameter("result");
        System.out.println(collumn);
        SQLControl control = new SQLControl();
        //get session

        control.updateStatus(id,collumn,result);
        response.sendRedirect("Home.jsp");

    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


        try {
            processRequest(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
