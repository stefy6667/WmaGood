package Servlet;

import Model.PrepareOrder;
import Service.SQLControl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class narghileaDeskServlet extends javax.servlet.http.HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        String id = request.getParameter("id");
        SQLControl control = new SQLControl();
        //get session
        List<PrepareOrder> order = control.prepareOrderHookah(id);
        control.updateTable(id,"getReadyNar","notDeliver","'Table "+order.get(0).getTable()+" Ready From Hookah'");
        control.updateStatus1(id,"ready","ready",order.get(0).getpName());
        response.sendRedirect("hookahDesk.jsp");

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
