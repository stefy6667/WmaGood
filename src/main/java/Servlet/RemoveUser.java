package Servlet;

import Service.SQLControl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RemoveUser extends javax.servlet.http.HttpServlet {
    private String index;
    protected void doGet_Remove(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        SQLControl control = new SQLControl();
        String index = request.getParameter("id");
        control.deleteUserById(Integer.parseInt(index));

        response.sendRedirect("RemoveUser.jsp");
    }



    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            doGet_Remove(request, response);

    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        doGet(request, response);
    }

}
