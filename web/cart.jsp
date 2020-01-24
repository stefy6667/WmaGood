
<%@page import="Model.Cart"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta name="viewport" content="width=device-width">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Order Detail</title>
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
        .button {
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
<body>

<h1>Order Detail</h1>

<form action="ShoppingCardServlet" method="POST" id="1">
    <label>Type Tabel Number Create Order:
    <input type="text" name="cID" required>
    </label>
    <table border="0">
        <thead>
        <tr>
            <th>Product</th>
            <th>Quantity</th>
            <th>Price</th>
            <th>Action</th>
        </tr>
        </thead>
        <tbody>

        <%
            Double totalOrder = 0.0;
            HttpSession newSession = request.getSession();
            if (newSession.getAttribute("cart") != null) {
                ArrayList<Cart> arrC = (ArrayList<Cart>) newSession.getAttribute("cart");
                for (int i = 0; i < arrC.size(); i++) {
                    totalOrder += (arrC.get(i).getQuantity() * arrC.get(i).getpPrice());
        %>
        <tr>
            <td><%= arrC.get(i).getpName()%></td>
            <td><%= arrC.get(i).getQuantity()%></td>
            <td><%= arrC.get(i).getpPrice()%></td>
            <th><a href="ShoppingCardServlet?id=<%=arrC.get(i).getpID()%>&action=remove" class="button">Remove</a></th>

        </tr>
        <%      }
        } else {
        %>
        <h1>YOU DONT BUY ANYTHING</h1>
        <%
            }

        %>
        </tbody>
    </table>

    <p>Total: <%= totalOrder%></p>
    <input type="submit" value="Add New Order" name="add"/>

    </form>
<form action="ShoppingCardServlet" method="POST">
    <label>Type Tabel Number To Edit Order:
        <input type="text" name="acOrd" required>
        <input type="submit" name="edit" value="Edit Order">
    </label>
</form>
        <p><a href="Home.jsp">Back to buy</a></p>
</body>
</html>




