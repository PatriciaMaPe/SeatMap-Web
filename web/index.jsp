<%-- 
    Document   : login
    Created on : 16-jun-2015, 16:23:43
    Author     : Patripon
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <form action="LoginServlet"> 
            DNI:<input type="text" name="dni"/><br>
            Password:<input type="password" name="pass"/><br>
            <input type="submit" value="Login">
        </form>
        
        <input type="button" value="Registrarse" 
               onclick="window.open('http://localhost:8080/Formulario/registro.jsp')">
        </input>
    </body>
</html>
