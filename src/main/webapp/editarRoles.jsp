<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
<!-- Vale por la etiqueta head -->
<%@ include file="header.jsp" %>
<body>
    <h2>Editar rol</h2>
    <form action="/GestorUsuarios/RoleServlet?accion=edit" method="POST">
        <label for="nombre">Nombre de rol</label>
        <input type="text" id="nombre" name="nombre" value='<c:out value="${rol.nombre}" />' required /> <br />
        <button type="submit">Agregar rol</button>
    </form>
</body>
</html>