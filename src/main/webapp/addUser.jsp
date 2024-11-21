<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<!-- Vale por la etiqueta head -->
<%@ include file="header.jsp" %>
<body>
    <h2>Agrega usuarios</h2>
    <br />
    <form action="/GestorUsuarios/userServlet?accion=add" method="POST">
        <label for="nombre">Nombre</label>
        <input type="text" name="nombre" id="nombre" required /> <br />
        <label for="correo">Correo</label>
        <input type="email" id="correo" name="correo" required /> <br />
        <label for="clave">Clave</label>
        <input type="text" name="clave" id="clave" required /> <br />
        <label for="idRol">Rol</label>
        <c:if test="${empty xroles}">
        	<p>Vacio</p>
            <input type="text" name="role" id="role" value="Usuario" /> <br />
        </c:if>
        <c:if test="${not empty xroles}">
            <select name="idRol" id="idRol">
                <c:forEach var="rol" items="${xroles}">
                    <option value="${rol.id_rol}"><c:out value="${rol.nombre}" /></option>
                </c:forEach>
            </select>
        </c:if>

        <button type="submit">Agregar usuario</button>
    </form>
</body>
</html>