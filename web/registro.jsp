<%-- 
    Document   : invalidLogin
    Created on : 16-jun-2015, 19:25:34
    Author     : Patripon
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registro</title>
    </head>
    <body>
    <center>
         Registrate!
         
         <form name="Datos Input" action="registroInsert.jsp">
            <p>Introduce los datos</p>
            <p>Nombre: <input type="text" name="nombre" value="" /></p>
            <p>Apellidos: <input type="text" name="apellidos" value="" /></p>
            <p>DNI: <input type="text" name="dni" value="" /></p>
            <p>Password: <input type="password" name="pass" value="" /></p>
            <input type="submit" value="Registrarse">
        </input>
        </form>
    </center>
    </body>
</html>
