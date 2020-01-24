<%@ page import="Model.OrderModel" %>
<%@ page import="Model.PrepareOrder" %>
<%@ page import="Service.SQLControl" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="java.util.ArrayList" %>
<%--
  Created by IntelliJ IDEA.
  User: andrei
  Date: 8/31/2019
  Time: 12:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta name="viewport" content="width=device-width">
    <title>User Form</title>

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

        form {
            border-radius: 3px;
            border: 1px solid lightcoral;
            padding: 24px;

        }

        input[type=text], select {
            width: 100%;
            padding: 12px 20px;
            margin: 8px 0;
            display: inline-block;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
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
<body style="text-align: center">

<h1>Search Table</h1>
<form action="print.jsp" method="post">
    <label for="name">Table Number:</label>
    <input type="text" id="name" name="name" required>
    <br>
    <br>
    <input type="submit" name="search" value="Search">
</form>

</body>
</html>



