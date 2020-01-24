package Servlet;

import Model.Product;
import Service.SQLControl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AddProducts extends HttpServlet {
    private int id;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("AddProduct.jsp");
        requestDispatcher.forward(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String firstName = req.getParameter("firstname");
        String lastname = req.getParameter("lastname");
        String email = req.getParameter("email");
        double phone = Double.parseDouble(req.getParameter("phone"));
        System.out.println(firstName + lastname + email + phone);


        id++;
        HttpSession session = req.getSession();
        session.setAttribute("id",id);
        int i = (int) session.getAttribute("id");

        String pId = Integer.toString(i+1);
        System.out.println(pId);
        Product product = new Product(pId,firstName,lastname,email,phone);

        SQLControl control = new SQLControl();
        control.addProduct(product);

        doGet(req, resp);
    }
}
