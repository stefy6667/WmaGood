<%--
    Document   : product
    Created on : Sep 26, 2017, 2:17:25 PM
    Author     : DC
--%>


<%@page import="java.util.ArrayList" %>
<%@ page import="Service.SQLControl" %>
<%@ page import="Model.Product" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="Model.OrderModel" %>
<%@ page import="Model.PrepareOrder" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <meta name="viewport" content="width=device-width">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="refresh" content="5"/>
  
    <title>List products</title>



    <style>
        table {
            border-collapse: collapse;
            width: 100%;
        }

        th, td {
            text-align: left;
            padding: 8px;
        }

        tr:nth-child(even) {background-color: #f2f2f2;}


        input[type=submit] {
            width: 100%;
            background-color: #4CAF50;
            color: white;
            padding: 14px 20px;
            margin: 8px 0;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }

        input[type=submit]:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
<%
    SQLControl control = new SQLControl();
    ArrayList<OrderModel> arrP1 = null;
    try {
        arrP1 = control.orderNameBar();
    } catch (SQLException e) {
        e.printStackTrace();
    }

%>
<h1>Drink's Order</h1>
<table border="1">
    <thead>
    <tr>
        <th>Table</th>
        <th>Name : Quantity</th>
        <th>Action</th>
    </tr>
    </thead>
    <tbody>
    <% if (arrP1 != null) {
        ArrayList<PrepareOrder> arrP = new ArrayList<PrepareOrder>();


        for (int i = 0; i < arrP1.size(); i++) {
            String result = arrP1.get(i).getOrderNumber();
            System.out.println(result);
            arrP = (ArrayList<PrepareOrder>) control.prepareOrderBar(result);%>
 			  
    <tr>
      <% for (int k = 0; k < arrP.size(); k++) {
            if (arrP.get(k) != null) {%>
        <td><%=arrP1.get(i).getTabel()%></td>
        <td><%
            
            for (int j = 0; j < arrP.size(); j++) {
            
        %>

            <%="Product :"+arrP.get(j).getpName()%>: <%= "Quantity :"+arrP.get(j).getQuantity()%>
        

                <br>
            <%  }%></td>
        <td><a href="BarDeskServlet?id=<%=arrP1.get(i).getOrderNumber()%>"><input type="submit" value="Ready"/></a></td>
      <%break;}}%>
    </tr>
    <%
     
      }
        }
    %>
    </tbody>
</table>


</body>
</html>



