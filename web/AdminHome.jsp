<%@ page import="Service.SQLControl" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="Model.OrderModel" %>
<%@ page import="Model.PrepareOrder" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.time.LocalDate" %>
<%@ page import="java.time.ZoneId" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--
  Created by IntelliJ IDEA.
  User: andrei
  Date: 18.10.2019
  Time: 14:30
  To change this template use File | Settings | File Templates.
--%>

<html>
<head>

    <title>Admin</title>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <style>

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
            width: 100%;
            background-color: #4CAF50;
            color: white;
            padding: 14px 20px;
            margin: 8px 0;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }

        .button2 {
            width: 100%;
            background-color: #4CAF50;
            color: white;
            padding: 14px 20px;
            margin: 8px 0;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }

        .button3 {
            width: 100%;
            background-color: #4CAF50;
            color: white;
            padding: 14px 20px;
            margin: 8px 0;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }


    </style>
</head>
<body class="w3-light-grey">
<%  PrintWriter ou1t = response.getWriter();

    if(session.getAttribute("name") == null){
        ou1t.println("<script type=\"text/javascript\">");
        ou1t.println("alert('You need to LogIN');");
        ou1t.println("location='Admin.jsp';");
        ou1t.println("</script>");
    }

%>
<div class="w3-container w3-blue-grey w3-opacity w3-right-align">
    <h1>Admin</h1>
</div>


<div class="w3-container w3-padding">

    <table align="center">
        <tr>
            <td>
                <div class="w3-card-4" align="center">
                    <div class="w3-container w3-center w3-green">

                        <h2>Total Today</h2>
                    </div>
                    <% Date date3 = new Date();
                        LocalDate localDate3 = date3.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                        int month3 = localDate3.getDayOfMonth();
                        SQLControl control3 = new SQLControl();
                    %>
                    <%= control3.totalToday(month3)%>
                </div>

            </td>

            <td style="padding:0 25px 0 25px;">
                <div class="w3-card-4" align="center">
                    <div class="w3-container w3-center w3-green">

                        <h2>Total This Mounth</h2>
                    </div>
                    <% Date date2 = new Date();
                        LocalDate localDate2 = date2.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                        int month2 = localDate2.getMonthValue();
                        SQLControl control2 = new SQLControl();

                    %>
                    <%=control2.totalThisMounth(month2)%>
                </div>

            </td>
            <td style="padding:0 25px 0 25px;">
                <div class="w3-card-4" align="center">
                    <div class="w3-container w3-center w3-green">

                        <h2>Total Last Mounth</h2>
                    </div>
                    <% Date date = new Date();
                        LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                        int month = localDate.getMonthValue();
                        int last = month - 1;
                        SQLControl control = new SQLControl();
                    %>
                    <%=control.totalThisMounth(last)%>
                </div>

            </td>
        </tr>
    </table>
    <table align="center">
        <tr>

            <td><a href="AddProduct.jsp">
                <button class="button button1">Add Product</button>
            </a></td>

            <td><a href="UpdateProducts.jsp">
                <button class="button button2">Update Stock/Remove Product</button>
            </a></td>


            <td><a href="Raport.jsp">
                <button class="button button3">Order Report</button>
            </a></td></tr>
        <tr>
            <td><a href="AddUser.jsp">
                <button class="button button3">Add User</button>
            </a></td>
            <td><a href="RemoveUser.jsp">
                <button class="button button3">View/Remove User</button>
            </a></td>
        </tr>


    </table>
    <div class="w3-container w3-grey w3-opacity w3-right-align w3-padding">
        <button class="w3-btn w3-round-large" onclick="location.href='/Admin.jsp'">Back to main</button>
    </div>
</div>


</body>
</html>
