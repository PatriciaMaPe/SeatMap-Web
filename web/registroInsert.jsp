
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%-- 
    Document   : response
    Created on : 14-jun-2015, 1:06:12
    Author     : Patripon
--%>
<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registro Validos</title>
    </head>
    <body>
        <p>Datos</p>
        <jsp:useBean id="personaBean" scope="session" class="beans.Persona" />
        <p><jsp:setProperty name="personaBean" property="nombre"/></p>
        <p><jsp:setProperty name="personaBean" property="apellidos" /></p>
        <p><jsp:setProperty name="personaBean" property="dni" /></p>
        <p><jsp:setProperty name="personaBean" property="pass" /></p>


        <!-- INSERT DE LOS DATOS INTRODUCIDOS -->

        <sql:setDataSource  var="con"   driver="com.mysql.jdbc.Driver" 
                            url="jdbc:mysql://localhost:3306/usuarios"

                            user="root"
                            password="root"
                            />


        <sql:update var="datos" dataSource="${con}">
            INSERT INTO personas VALUES (
            '<jsp:getProperty name="personaBean" property="nombre"/>', 
            '<jsp:getProperty name="personaBean" property="apellidos" />',
            '<jsp:getProperty name="personaBean" property="dni" />',
            '<jsp:getProperty name="personaBean" property="pass" />'
            );
        </sql:update>

        <sql:query var="result" dataSource="${con}">
            SELECT nombre,apellidos,dni,pass FROM personas;
        </sql:query>

            
        <!-- VISUALIZO: -->
        <p>Te has registrado correctamente</p>
        <p>Nombre: <jsp:getProperty name="personaBean" property="nombre" /></p>
        <p>Apellidos: <jsp:getProperty name="personaBean" property="apellidos" /></p>
        <p>DNI: <jsp:getProperty name="personaBean" property="dni" /></p>
        <p>Password: <jsp:getProperty name="personaBean" property="pass" /></p>
        
        <form name="Datos Input" action="index.jsp">
            <input type="submit" value="Login" />
        </form>
    </body>
</html>
