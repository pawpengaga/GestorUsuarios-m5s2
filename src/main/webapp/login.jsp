<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<!-- Vale por la etiqueta head -->
<%@ include file="header.jsp" %>
<body>
    <h2>Inicio de sesion</h2>
    <form action="/GestorUsuarios/AuthServlet" method="POST">
        <label for="usuario">Usuario</label><br>
        <input type="text" name="usuario" id="usuario" required />
        <label for="clave">Clave</label><br>
        <input type="text" name="clave" id="clave" required />
        <br>
        <button type="submit">Iniciar sesion</button>
    </form>
    <c:if test="${param.error == 'invalid'}">
        <p style="color: red;">Usuario o contraseña incorrecta...</p>
    </c:if>
</body>
</html>