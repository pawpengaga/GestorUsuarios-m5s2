<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="jakarta.tags.core" prefix="c" %>
    <%@ page import="jakarta.servlet.http.Cookie" %>
    <%
        String usuario = null;
        Cookie[] cookies = request.getCookies();
        if(cookies != null){
            for(Cookie cookie : cookies){
                if("usuario".equals(cookie.getName())){
                    usuario = cookie.getValue();
                    break;
                }
            }
        }
    %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Gestor Usuarios</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
	<h1>Bienvenido <c:out value="${usuario}" default="INVITADO" /> </h1>
    <p><a href="logout.jsp">Cerrar Sesión</a></p>
    <!-- Se llega al index solo cuando se ha pasado la validacion -->
    <!-- <c:if test="${usuario}"> -->
    <!-- </c:if> -->
	<br />
    <ul>
        <li><a href="/GestorUsuarios/RoleServlet?accion=add">Agregar Rol</a></li>
        <li><a href="/GestorUsuarios/userServlet?accion=listar">Listar usuarios</a></li>
        <li><a href="/GestorUsuarios/userServlet?accion=add">Agregar usuarios</a></li>
        <li><a href="logout.jsp">Cerrar Sesión</a></li>
    </ul>
	
</body>
</html>