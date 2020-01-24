<%--
    Document   : product
    Created on : Sep 26, 2017, 2:17:25 PM
    Author     : DC
--%>


<%@page import="Model.OrderModel" %>
<%@ page import="Service.SQLControl" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="java.util.ArrayList" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
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
  <script type="text/javascript">
		/*
		alert("navigator.vibrate?  " + (navigator.vibrate ? "Yes" : "No"));
		alert("navigator.webkitVibrate?  " + (navigator.webkitVibrate ? "Yes" : "No"));
		alert("navigator.oVibrate?  " + (navigator.oVibrate ? "Yes" : "No"));
		*/
		 function startVibrate(level) {
			navigator.vibrate(level);
		}

		var vibrateInterval;
		function startPeristentVibrate(level, interval) {
			vibrateInterval = setInterval(function() {
				startVibrate(level);
			}, interval);
		}
		
		function stopVibrate() {
			if(vibrateInterval) clearInterval(vibrateInterval);
			navigator.vibrate(0);
		}
	</script>

<script>
z={analyticsID:"UA-2087880-2",themePath:"/wp-content/themes/punky",pluginPath:"libs/curl/src/curl/plugin/",domain:"davidwalsh.name",loadSidebar:!(-1!=navigator.userAgent.toLowerCase().indexOf("googlebot")),d:document,w:this},z.baseUrl=z.themePath+"/js/",location.hostname.indexOf(z.domain)<0&&(z.isDebug=1,z.analyticsID=0),z.moo=z.baseUrl+"MooTools-Core-1.6.0.js";z.analyticsID&&function(){!function(e,a,t,n,c,s,i){e.GoogleAnalyticsObject=c,e[c]=e[c]||function(){(e[c].q=e[c].q||[]).push(arguments)},e[c].l=1*new Date,s=a.createElement(t),i=a.getElementsByTagName(t)[0],s.async=1,s.src=n,i.parentNode.insertBefore(s,i)}(z.w,z.d,"script","//www.google-analytics.com/analytics.js","ga"),ga("create",z.analyticsID,{siteSpeedSampleRate:50}),ga("set","forceSSL",!0),ga("send","pageview"),ga("set","nonInteraction",!0)}();</script>

<script>
window.ORIGINAL_JSON=window.JSON;
</script>
</head>
<body>


<%

    SQLControl control = new SQLControl();
    ArrayList<OrderModel> arrP = null;
    ArrayList<OrderModel> arrPBuc = null;
    ArrayList<OrderModel> arrPNar = null;
    try {
        arrP = control.orderStatus();
    } catch (SQLException e) {
        e.printStackTrace();
    }
    try {
        arrPBuc = control.orderStatusBuc();
    } catch (SQLException e) {
        e.printStackTrace();
    }
    try {
        arrPNar = control.orderStatusNar();
    } catch (SQLException e) {
        e.printStackTrace();
    }
    if (arrP != null) {

        for (int i = 0; i < arrP.size(); i++) {
            if (arrP.get(i).getWaiterId().equals(session.getAttribute("name"))) {
                if (!arrP.get(i).getReady().equals("notReady")) {
                    String column = "readyBar";
                    String result = "DeliverBar";

                    out.println("<script type=\"text/javascript\">");
                    out.println("alert('" + arrP.get(i).getReady() + "');");                
                    out.println("location='HomeServlet?id=" + arrP.get(i).getOrderNumber() + "&column=" + column + "&result=" + result + "';");                
                    out.println("</script>");
                  
                }
            }
        }
        for (int j = 0; j < arrPNar.size(); j++) {
            if (arrPNar.get(j).getWaiterId().equals(session.getAttribute("name"))) {
                if (!arrPNar.get(j).getGetReadyNar().equals("notReady")) {
                    String column = "getReadyNar";
                    String result = "DeliverNar";
                    out.println("<script type=\"text/javascript\">");
                    out.println("alert('" + arrPNar.get(j).getGetReadyNar() + "');");
                    out.println("location='HomeServlet?id=" + arrPNar.get(j).getOrderNumber() + "&column=" + column + "&result=" + result + "';");
                    out.println("</script>");
                }
            }
        }
        for (int k = 0; k < arrPBuc.size(); k++) {
            if (arrPBuc.get(k).getWaiterId().equals(session.getAttribute("name"))) {
                if (!arrPBuc.get(k).getReadyBuc().equals("notReady")) {
                    String column = "readyBuc";
                    String result = "DeliverBuc";
                      out.println("<script type=\"text/javascript\">");
                    out.println("alert('" + arrPBuc.get(k).getReadyBuc() + "');");
                    out.println("location='HomeServlet?id=" + arrPNar.get(k).getOrderNumber() + "&column=" + column + "&result=" + result + "';");
                    out.println("</script>");
                }
            }
        }
    }%>
 <center>
  <h1>Start Order</h1>
<table border="1" align="center">
    <tbody align="center">

    <tr>
        <td><a href="BarOrder.jsp">
            <button class="button button1">Drinks</button>
        </a></td>
    </tr>
    <tr>
        <td><a href="BucatarieOrder.jsp">
            <button class="button button2">Food</button>
        </a></td>
    </tr>
    <tr>
        <td><a href="NargileaOrder.jsp">
            <button class="button button3">Shisha</button>
        </a></td>
    

    </tr>
    </tbody>
</table>
</center>

</body>
</html>





