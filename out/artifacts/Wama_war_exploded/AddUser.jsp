<%@ page import="java.io.PrintWriter" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <title>Add new user</title>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
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
    <h1>Add Product! </h1>
</div>

<div class="w3-container w3-padding">

    <div class="w3-card-4">
        <div class="w3-container w3-center w3-green">
            <h2>Add user</h2>
        </div>
        <form action="/AddUser" method="post" class="w3-selection w3-light-grey w3-padding">
            <label>User Name:
                <input type="text" name="firstname" class="w3-input w3-animate-input w3-border w3-round-large" style="width: 30%"><br />
            </label>
            <label>Category Waiter/Admin:
                <input type="text" name="lastname" class="w3-input w3-animate-input w3-border w3-round-large" style="width: 30%"><br />
            </label>
            <label>CodeId:
                <input type="text" name="email" class="w3-input w3-animate-input w3-border w3-round-large" style="width: 30%"><br />
            </label>

            <button type="submit" class="w3-btn w3-green w3-round-large w3-margin-bottom">Submit</button>
        </form>
    </div>
</div>

<div class="w3-container w3-grey w3-opacity w3-right-align w3-padding">
    <button class="w3-btn w3-round-large" onclick="location.href='/Admin.jsp'">Back to main</button>
</div>
</body>
</html>

