<%-- 
    Document   : perfil
    Created on : 18-jun-2015, 1:36:09
    Author     : Patripon
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="beans.Persona"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <% Persona usuarioActual = (Persona) (session.getAttribute("UsuarioSesionActual"));%>
        <h1>Datos Perfil</h1>
        <p>Nombre: <%=usuarioActual.getNombre()%></p>
        <p>Apellidos: <%=usuarioActual.getApellidos()%></p>
        <p>DNI: <%=usuarioActual.getDni()%></p>
        
        <input type="button" value="Volver" 
               onclick="window.open('http://localhost:8080/Formulario/mapaAsientos.jsp')">
        </input>
    </body>
</html>
