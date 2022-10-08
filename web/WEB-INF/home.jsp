<%-- 
    Document   : home
    Created on : 6-Oct-2022, 8:53:28 AM
    Author     : Jireh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
    </head>
    <body>
        <h2>Home Page</h2>
        <h4>Hello ${user.username}</h4>
        <a href="login?logout">Log out</a>
    </body>
</html>
