<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="jakarta.tags.core" prefix="c" %>
    <%@ page import="jakarta.servlet.http.Cookie" %>
    <%@ page import="jakarta.servlet.http.HttpSession" %>
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
	<h1>Bienvenido, <c:out value="${usuario}" default="INVITADO" /></h1>
    <%
    // HttpSession session = request.getSession(false); // La s extra fue quitada...
    if (session.getAttribute("usuario") != null) { %>
        <p><a href="logout.jsp">Cerrar Sesión</a></p>
    <% } %>
	<br />
    <ul>
        <li><a href="/GestorUsuarios/RoleServlet?accion=add">Agregar Rol</a></li>
        <li><a href="/GestorUsuarios/userServlet?accion=listar">Listar usuarios</a></li>
        <li><a href="/GestorUsuarios/userServlet?accion=add">Agregar usuarios</a></li>
        <% if (session.getAttribute("usuario") != null) { %>
       		<li><a href="logout.jsp">Cerrar Sesión</a></li>
    	<% } %>
        <!-- <li><a href="logout.jsp">Cerrar Sesión</a></li> -->
        <!-- <c:out value="${usuario}" default="INVITADO" /> -->
    </ul>
	
</body>
</html>