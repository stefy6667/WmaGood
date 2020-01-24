package Servlet;

import Service.SQLControl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UpdateProducts extends javax.servlet.http.HttpServlet {
   private String index;
    protected void doGet_Remove(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        SQLControl control = new SQLControl();
        String index = request.getParameter("id");
        control.deleteById(Integer.parseInt(index));

        response.sendRedirect("UpdateProducts.jsp");
    }

    protected void updateQuantiti(HttpServletRequest request, HttpServletResponse response) throws IOException {
        SQLControl control = new SQLControl();
        String cID = request.getParameter("cID");
         index = request.getParameter("id");
        System.out.println(index);
        control.updateQuantiti(cID, index);
        response.sendRedirect("UpdateProducts.jsp");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String acc = request.getParameter("action");
        String action = "";
        if (request.getParameter("Add") != null) {
            action = "new";
            System.out.println(action);
        }
        if (action.equals("new")) {
            updateQuantiti(request, response);
        } else if (acc.equals("remove")) {
            doGet_Remove(request, response);

        }


    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        doGet(request, response);
    }

}
