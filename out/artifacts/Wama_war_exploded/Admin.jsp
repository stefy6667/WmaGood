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
    <meta name="viewport" content="width=device-width">
    <style>
        form{
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

</head >
<body style="text-align: center">

<h1>LogIn</h1>
<form action ="/Admin" method="post">
    <label for="name">Enter Your Admin Id:</label>
    <input tyoe="text" id="name" name="name" required>
    <br>
    <br>
    <input type="submit" value="LogIn">
</form>



</body>
</html>



