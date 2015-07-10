<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>

<%-- 
    Document   : userLogged
    Created on : 16-jun-2015, 19:20:04
    Author     : Patripon
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="beans.Persona"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sesion iniciada</title>
    </head>
    <body>
    
        <% Persona usuarioActual = (Persona) (session.getAttribute("UsuarioSesionActual"));%>
        Usuario: <%= usuarioActual.getNombre() + " " + usuarioActual.getApellidos()%>
        <form name="VerPerfil" action="perfil.jsp" >
             <input type="submit" name="perfil" value="Perfil"/>
        </form>
        <form name="VerPerfil" action="index.jsp" >
             <input type="submit" name="perfil" value="Cerrar sesion"/>
        </form>
        
        </form>
        <p>MAPA ASIENTOS</p>

        <sql:setDataSource  var="con"   driver="com.mysql.jdbc.Driver" 
                            url="jdbc:mysql://localhost:3306/usuarios"

                            user="root"
                            password="root"
                            />

        <sql:query var="result" dataSource="${con}">
            SELECT dni FROM asientos;
        </sql:query>
        <sql:query var="result2" dataSource="${con}">
            SELECT cAsiento FROM asientos;
        </sql:query>

            <form name="ComprarAsiento" action="CompraServlet" >
            <table border="1">
                <tr>
                <c:forEach var="row2" items="${result2.rowsByIndex}">
                    <c:forEach var="column2" items="${row2}">
                        <td><input type="radio" name="seatmap" value="${column2}">
                        <c:out value="${column2}"/></td> 
                    </c:forEach>
                </c:forEach>
                <tr>
                <tr>      
                <c:forEach var="row" items="${result.rowsByIndex}">
                    <c:forEach var="column" items="${row}"> 
                        <c:choose>
                            <c:when test="${column==null}">
                                <td style="background-color:greenyellow;"><c:out value="${'libre'}"/></td>
                            </c:when>
                            <c:otherwise>
                                <td style="background-color:red;"><c:out value="${'ocupado'}"/></td>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>

                </c:forEach>
                </tr>
            </table>
           
            <input type="hidden" name="dniOculto" value="<%=usuarioActual.getDni()%>">
            
            <input type="submit" name="comprar" value="Comprar"/>
            <input type="submit" name="borrar" value="Borrar"/>
        </form>
             
    
</body>
</html>
