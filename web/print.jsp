<%@ page import="Model.OrderModel" %>
<%@ page import="Model.PrepareOrder" %>
<%@ page import="Service.SQLControl" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="java.time.LocalDateTime" %>
<%@ page import="java.time.format.DateTimeFormatter" %>
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
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
</head>
<body style="text-align: center">

<img src="${pageContext.request.contextPath}/home/andrei/logo.jpg">

<h1>Business Name</h1>
<h2>Queen Street 42 </h2>
<h3>NN16 0BZ</h3>
<h3>Phone ... Mail...</h3>
<h3><%
    LocalDateTime dateTime = LocalDateTime.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
%> <%= dateTime.format(formatter)%>
</h3>
<%
    SQLControl control = new SQLControl();
    ArrayList<OrderModel> arrP1 = null;
    String table = request.getParameter("name");
    System.out.println(table);
    double total = 0.0;
    try {
        arrP1 = control.CheckOutOrdeName(table);
    } catch (SQLException e) {
        e.printStackTrace();
    }

%>

<table>
    <thead>
    <tr>

        <th>Name</th>
        <th>Quantity</th>
        <th>Price</th>

    </tr>
    </thead>
    <tbody>
    <% if (arrP1 != null) {
        ArrayList<PrepareOrder> arrP;


        for (int i = 0; i < arrP1.size(); i++) {
            String result = arrP1.get(i).getOrderNumber();
            System.out.println(result);
            arrP = (ArrayList<PrepareOrder>) control.CheckOut(result);%>

    <tr>

            <%
            for (int j = 0; j < arrP.size(); j++) {
        %>

    <tr>
        <td><%=  arrP.get(j).getpName()%>
        </td>
        <td><%=  arrP.get(j).getQuantity()%>
        </td>

        <td><%=  arrP.get(j).getPrice() + " £"%>
        </td>
    </tr>

    <br>
    <% }%>
    <%total = arrP1.get(i).getTotal();%>
    <script>

        window.onafterprint = function(e){
            closePrintView();
        };

        function myFunction(){
            window.print();
        }

        function closePrintView() {
            window.location.href = '${pageContext.request.contextPath}/CheckOutServlet?t=<%=arrP1.get(i).getOrderNumber()%>';
        }

        </script>
    <button onClick="myFunction()" class="button">CheckOut</button>

    <%
            }

        }
    %>
    </tbody>
</table>

<p>Total with VAT: <%= total + "£"%>
</p>
<p>VAT Number....</p>
<%double tax = (total*20)/100;%>
<p>INCI TAX:20.00%  AMOUNT <%= total + "£"%>  TAX: <%= tax+"£"%> </p>

<input type="checkbox">Card<br>
<input type="checkbox">Cash<br>

</body>
</html>
