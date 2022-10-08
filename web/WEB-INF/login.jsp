<%-- 
    Document   : login
    Created on : 6-Oct-2022, 8:39:39 AM
    Author     : Jireh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <h2>Login</h2>
        <form action="login" method="post">
            Username: <input type="text" name="username" value="${username}"> <br>
            Password: <input type="text" name="password" value="${password}"> <br>
            <input type="submit" value="Log in">
        </form> <br>
         ${message}
    </body>
</html>
