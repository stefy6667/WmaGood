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

public class InedxServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        request.setAttribute("yourname", name);
        HttpSession sesion = request.getSession(true);
        sesion.setAttribute("name", name);
        SQLControl control = new SQLControl();
        ArrayList<UserModel> user = new ArrayList<>();

        user = (ArrayList<UserModel>) control.getAllPers();
        PrintWriter out = response.getWriter();
        for(int i = 0; i < user.size();i++){
            if(user.get(i).getCodeId().equals(name)&&(user.get(i).getPermision().equals("Admin")||user.get(i).getPermision().equals("Waiter"))){
                response.sendRedirect("Home.jsp");

            }else {
                out.println("<script type=\"text/javascript\">");
                out.println("alert('Wrong Id please try again');");
                out.println("location='index.jsp';");
                out.println("</script>");
            }

        }


    }

}
