<%@page import="Model.Cart" %>
<%@page import="java.util.ArrayList" %>
<%@ page import="Service.SQLControl" %>
<%@ page import="Model.Product" %>
<%@ page import="java.io.PrintWriter" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
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

        tr:nth-child(even) {
            background-color: #f2f2f2;
        }





        .button {

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
<%  PrintWriter ou1t = response.getWriter();

    if(session.getAttribute("name") == null){
        ou1t.println("<script type=\"text/javascript\">");
        ou1t.println("alert('You need to LogIN');");
        ou1t.println("location='Admin.jsp';");
        ou1t.println("</script>");
    }

%>

<h1>Order Detail</h1>


    <label>Type Tabel Number Create Order:

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
            SQLControl control = new SQLControl();
            ArrayList<Product> arrC = (ArrayList<Product>) control.getAllUsers();


            if (arrC != null) {

                for (int i = 0; i < arrC.size(); i++) {

        %>
        <tr>
            <td><%= arrC.get(i).getpName()%>
            </td>
            <td><%= arrC.get(i).getQuantity()%>
            </td>
            <td><%= arrC.get(i).getpPrice()%>
            </td>
            <th><form action="UpdateProducts?id=<%=arrC.get(i).getpId()%>" method="POST"> <input type="text" name="cID" ><input type="submit" value="Update" name="Add" class="button"/><a href="UpdateProducts?id=<%=arrC.get(i).getId()%>&action=remove" class="button">Remove</a></form></th>

        </tr>
        <%
                }
            }
        %>

        </tbody>
    </table>


<div class="w3-container w3-grey w3-opacity w3-right-align w3-padding">
    <button class="w3-btn w3-round-large" onclick="location.href='/Admin.jsp'">Back to main</button>
</div>



</body>
</html>




