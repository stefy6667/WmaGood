<%@ page import="Service.SQLControl" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="Model.OrderModel" %>
<%@ page import="Model.PrepareOrder" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.time.LocalDate" %>
<%@ page import="java.time.ZoneId" %>
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

    <title>Report</title>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
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
    <h1>Report</h1>
</div>


<div class="w3-container w3-padding">

    <table>
        <tr>
            <td>
                <div class="w3-card-4">
                    <div class="w3-container w3-center w3-green">

                        <h2>Search By Mounth Ex : 1 from January</h2>
                    </div>
                    <form name="search" method="post" class="w3-selection w3-light-grey w3-padding">
                        <label>Search:
                            <input type="text" name="name" class="w3-input w3-animate-input w3-border w3-round-large"
                                   style="width: 30%"><br/>
                        </label>
                        <button class="w3-btn w3-green w3-round-large w3-margin-bottom"
                                type="submit" name="form">Submit
                        </button>

                    </form>
                </div>
                <table align="center">
                    <% String[] submit = request.getParameterValues("name");
                        String par = request.getParameter("name");
                        SQLControl control = new SQLControl();

                        if (submit != null) {
                            ArrayList<OrderModel> arr = control.OrderMounth(Integer.parseInt(par));
                            for (int i = 0; i < arr.size(); i++) {%>
                    <tr>
                        <td>
                            <%="Order Name: " + arr.get(i).getOrderNumber() %> <%= "Waiter Name: " + arr.get(i).getWaiterId()%> <%="Table Number: " + arr.get(i).getTabel()%>  <%="Date: " + arr.get(i).getDate()%> <%="Total: " + arr.get(i).getTotal()%>
                        </td>

                    </tr>

                    <% }

                    }%>
                </table>
            </td>

            <td style="padding:0 25px 0 25px;">
                <div class="w3-card-4">
                    <div class="w3-container w3-center w3-green">

                        <h2>Search By Waiter Id Ex : 1234</h2>
                    </div>
                    <form name="search" method="post" class="w3-selection w3-light-grey w3-padding" >
                        <label>Search:
                            <input type="text" name="name1" class="w3-input w3-animate-input w3-border w3-round-large"
                                   style="width: 30%"><br/>
                        </label>
                        <button class="w3-btn w3-green w3-round-large w3-margin-bottom"
                                type="submit" name="form">Submit
                        </button>

                    </form>
                </div>
                <table align="center">
                    <% String[] submit1 = request.getParameterValues("name1");
                        String par1 = request.getParameter("name1");
                        SQLControl control1 = new SQLControl();

                        if (submit1 != null) {
                            ArrayList<OrderModel> arr = control1.OrderWaiter(par1);
                            for (int i = 0; i < arr.size(); i++) {%>
                    <tr>
                        <td>
                            <%="Order Name: " + arr.get(i).getOrderNumber() %> <%= "Waiter Name: " + arr.get(i).getWaiterId()%> <%="Table Number: " + arr.get(i).getTabel()%>  <%="Date: " + arr.get(i).getDate()%> <%="Total: " + arr.get(i).getTotal()%>
                        </td>

                    </tr>

                    <% }

                    }%>
                </table>
            </td>
            <td style="padding:0 25px 0 25px;">
                <div class="w3-card-4">
                    <div class="w3-container w3-center w3-green">

                        <h2>Search By Order Name Ex : Order_....</h2>
                    </div>
                    <form name="search" method="post" class="w3-selection w3-light-grey w3-padding" >
                        <label>Search:
                            <input type="text" name="name2" class="w3-input w3-animate-input w3-border w3-round-large"
                                   style="width: 30%"><br/>
                        </label>
                        <button class="w3-btn w3-green w3-round-large w3-margin-bottom"
                                type="submit" name="form">Submit
                        </button>

                    </form>
                </div>
                <table align="center">
                    <% String[] submit2 = request.getParameterValues("name2");
                        String par2 = request.getParameter("name2");
                        SQLControl control2 = new SQLControl();

                        if (submit2 != null) {
                            List<PrepareOrder> arr = control2.OrderByName(par2);
                            for (int i = 0; i < arr.size(); i++) {%>
                    <tr>
                        <td>
                            <%="Product Name: " + arr.get(i).getpName() %> <%="Table Number: " + arr.get(i).getTable()%> <%="Quantity: " + arr.get(i).getQuantity()%> <%="Price: " + arr.get(i).getPrice()%>
                        </td>

                    </tr>

                    <% }

                    }%>
                </table>
            </td>
        </tr>
    </table>
    <div class="w3-card-4">
        <div class="w3-container w3-center w3-green">

            <h2>Order Today</h2>
        </div>

    </div>
    <table align="center">
        <%
            Date date = new Date();
            LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            int month = localDate.getDayOfMonth();
            SQLControl control3 = new SQLControl();


            List<OrderModel> arr = control3.OrderToday(month);
            for (int i = 0; i < arr.size(); i++) {%>
        <tr>
            <td>
                <%="Order Name: " + arr.get(i).getOrderNumber() %> <%= "Waiter Name: " + arr.get(i).getWaiterId()%> <%="Table Number: " + arr.get(i).getTabel()%>  <%="Date: " + arr.get(i).getDate()%> <%="Total: " + arr.get(i).getTotal()%>
            </td>

        </tr>

        <%

            }%>
    </table>
    <div class="w3-container w3-grey w3-opacity w3-right-align w3-padding">
        <button class="w3-btn w3-round-large" onclick="location.href='/Admin.jsp'">Back to main</button>
    </div>
</div>


</body>
</html>
