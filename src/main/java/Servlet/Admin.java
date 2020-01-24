package Servlet;

import Model.UserModel;
import Service.SQLControl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Admin extends javax.servlet.http.HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        request.setAttribute("yourname", name);
        HttpSession sesion = request.getSession(true);
        sesion.setAttribute("name", name);
        sesion.setMaxInactiveInterval(30*60);
        SQLControl control = new SQLControl();
        ArrayList<UserModel> user = new ArrayList<>();

        user = (ArrayList<UserModel>) control.getAllPers();
        PrintWriter out = response.getWriter();
        for(int i = 0; i < user.size();i++){
            if(user.get(i).getCodeId().equals(name)&&user.get(i).getPermision().equals("Admin")){
                response.sendRedirect("AdminHome.jsp");

            }else {
                out.println("<script type=\"text/javascript\">");
                out.println("alert('Wrong Id please try again');");
                out.println("location='Admin.jsp';");
                out.println("</script>");
            }

        }


    }
}
