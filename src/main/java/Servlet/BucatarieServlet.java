package Servlet;

import Model.Cart;
import Model.Product;
import Service.SQLControl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class BucatarieServlet extends javax.servlet.http.HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        String id = request.getParameter("id");
        SQLControl control = new SQLControl();
        //get sessuin
        HttpSession session = request.getSession();
        ArrayList<Cart> arrCart = new ArrayList<Cart>();
        ArrayList<Product> arrPro = new ArrayList<Product>();

        //get product detail
        arrPro = control.selectProduct(id);

        //store product infomantion to session
        if (session.getAttribute("cart") == null) {
            //if not exist session cart
            //add new product to cart
            arrCart.add(new Cart(arrPro.get(0).getpId(), arrPro.get(0).getpName(), arrPro.get(0).getCategory(),arrPro.get(0).getpPrice(), 1));
        } else {
            arrCart = (ArrayList<Cart>) session.getAttribute("cart");
            //if ID is exist
            //increase quantity
            boolean checkID=false;
            for (int i = 0; i < arrCart.size(); i++) {
                if (arrCart.get(i).getpID().equalsIgnoreCase(id)) {
                    arrCart.get(i).setQuantity(arrCart.get(i).getQuantity() + 1);
                    checkID = true;
                    break;
                }
            }
            //if ID isn't exist
            if (checkID ==false) {
                arrCart.add(new Cart(arrPro.get(0).getpId(), arrPro.get(0).getpName(),arrPro.get(0).getCategory(), arrPro.get(0).getpPrice(), 1));
            }
        }
        //set session
        session.setAttribute("cart", arrCart);
        response.sendRedirect("BucatarieOrder.jsp");

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
