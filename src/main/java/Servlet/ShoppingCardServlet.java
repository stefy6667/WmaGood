package Servlet;

import Model.Cart;
import Model.OrderModel;
import Service.SQLControl;
import Util.HibernateUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

public class ShoppingCardServlet extends HttpServlet {
    private String cID;
     private String orderN;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        SQLControl control = new SQLControl();
        double total = 0.0;


        HttpSession session = request.getSession();
        //get cID,payMethod and date
        String waiter = (String) session.getAttribute("name");
        cID = request.getParameter("cID");
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String date = dateFormat.format(new Date());
        Random rand = new Random();
        System.out.println(cID);
        Date date1 = new Date();
        LocalDate localDate = date1.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        int month = localDate.getDayOfMonth();
        // Generate random integers in range 0 to 999
        int rand_int1 = rand.nextInt(10000);
        String orderName = "Order_" + rand_int1+month;
        PrintWriter out = response.getWriter();


        if (session.getAttribute("cart") != null) {
            //insert order table
            control.insertOrder(orderName);
            //insert orderline table
            String tableId = cID;
            ArrayList<Cart> arrC = (ArrayList<Cart>) session.getAttribute("cart");
            for (int i = 0; i < arrC.size(); i++) {
                String pID = arrC.get(i).getpID();
                String pName = arrC.get(i).getpName();
                String category = arrC.get(i).getCategory();

                int quantity = arrC.get(i).getQuantity();
                double price = arrC.get(i).getpPrice();
                total += (quantity * price);
                control.updateQuantitiOrder(quantity,pID);
                control.insertOrderLine(orderName, tableId, pID, pName, category, quantity, price,"notReady", date);
            }
            //destroy session

            control.createOrder(waiter, orderName, cID, "notReady", "notReady", "notReady", "notDeliver", date, total);
            session.removeAttribute("cart");

            response.sendRedirect("Home.jsp");
        } else {
            out.println("<script type=\"text/javascript\">");
            out.println("alert('You dont buy anything!! Plz buy something before checkout');");
            out.println("location='Home.jsp';");
            out.println("</script>");
        }


    }

    protected void editOrder(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        SQLControl control = new SQLControl();

        HttpSession session = request.getSession();
       String cI = request.getParameter("acOrd");
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String date = dateFormat.format(new Date());
        ArrayList<OrderModel> arrP1 = null;


        System.out.println(cI);



        if (session.getAttribute("cart") != null) {
            //insert order table
            arrP1 = control.CheckOutOrdeName(cI);
            for (int i = 0; i < arrP1.size(); i++) {
                orderN = arrP1.get(i).getOrderNumber();
                System.out.println(orderN);
            }
            //insert orderline table
            Double total =0.0;
            ArrayList<Cart> arrC = (ArrayList<Cart>) session.getAttribute("cart");
            for (int i = 0; i < arrC.size(); i++) {
                String pID = arrC.get(i).getpID();
                String pName = arrC.get(i).getpName();
                String category = arrC.get(i).getCategory();

                int quantity = arrC.get(i).getQuantity();
                double price = arrC.get(i).getpPrice();
            if(category.equals("bar")){
                control.updateStatus(orderN,"readyBar","notReady");
            }
               else if(category.equals("kitchen")){
                    control.updateStatus(orderN,"readyBuc","notReady");
                }
                else if(category.equals("hookah")){
                    control.updateStatus(orderN,"getReadyNar","notReady");
                }
                total += (quantity * price);
                control.updateQuantitiOrder(quantity,pID);
                control.updateTotal(Double.toString(total),orderN);
                control.insertOrderLine(orderN, cI, pID, pName, category, quantity, price,"notReady", date);
            }
            //destroy session

            session.removeAttribute("cart");
            response.sendRedirect("Home.jsp");
        }
    }

    protected void doGet_Remove(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        ArrayList<Cart> cart = (ArrayList<Cart>) session.getAttribute("cart");
        int index = isExisting(request.getParameter("id"), cart);
        cart.remove(index);
        session.setAttribute("cart", cart);
        response.sendRedirect("cart.jsp");
    }

    private int isExisting(String id, ArrayList<Cart> cart) {
        for (int i = 0; i < cart.size(); i++) {
            if (cart.get(i).getpID().equalsIgnoreCase(id)) {
                return i;
            }
        }
        return -1;
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String acc = request.getParameter("action");
        String action="";
        if (request.getParameter("add") != null) {
             action = "new";
            System.out.println(action);
        }else if(request.getParameter("edit")!=null){
            action="edit";
        }

        if (action.equals("new")) {
            processRequest(request, response);
        } else if (action.equals("edit")) {
            try {
                editOrder(request, response);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else if (acc.equals("remove")) {
            doGet_Remove(request, response);

        }

    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        doGet(request, response);
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }

}