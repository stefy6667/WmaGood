<%--
    Document   : product
    Created on : Sep 26, 2017, 2:17:25 PM
    Author     : DC
--%>


<%@page import="java.util.ArrayList" %>
<%@ page import="Service.SQLControl" %>
<%@ page import="Model.Product" %>
<%@ page import="java.sql.SQLException" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>List products</title>
    <style>
        .button {
            background-color: #4CAF50; /* Green */
            border: none;
            color: white;
            padding: 15px 32px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            font-size: 16px;
            margin: 4px 2px;
            cursor: pointer;
        }

        .button1 {
            background-color: white;
            color: black;
            border: 2px solid #4CAF50;
        }

        .button2 {
            background-color: white;
            color: black;
            border: 2px solid #008CBA;
        }

        .button3 {
            background-color: white;
            color: black;
            border: 2px solid #f44336;
        }

        table {
            border-collapse: collapse;
            width: 100%;
        }

        th, td {
            text-align: left;
            padding: 8px;
        }

        tr:nth-child(even) {
            background-color: #f2f2f2;
        }


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
    ArrayList<Product> arrP = null;
    try {
        arrP = control.selectAllProductBar();
    } catch (SQLException e) {
        e.printStackTrace();
    }

%>

<h1>Select Drinks</h1>
<table border="1">
    <thead>
    <tr>

        <th>Name</th>
        <th>Quantity</th>
        <th>Price</th>

        <th>Action</th>
    </tr>
    </thead>
    <tbody>
    <% if (arrP != null) {
        for (int i = 0; i < arrP.size(); i++) {
    %>
    <tr>
        <td><%= arrP.get(i).getpName()%>
        </td>
        <td><%= arrP.get(i).getQuantity()%>
        </td>
        <td><%= arrP.get(i).getpPrice()%>
        </td>
        <td>
            <a href="ProductServlet?id=<%=arrP.get(i).getpId()%>"><input type="submit" value="Add"/></a>
        </td>
    </tr>
    <% }
    }%>
    </tbody>
</table>

<div style="text-align: center;">
    <p><a href="cart.jsp">
        <button class="button button2">View Shopping Cart</button>
    </a></p>
    <a href="Home.jsp">
        <button class="button button1">Order</button>
    </a></div>

</body>
</html>




