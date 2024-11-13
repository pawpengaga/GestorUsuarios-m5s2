<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Gestor Usuarios</title>
</head>
<body>
    <h2>Agrega usuarios</h2>
    <br />
    <form action="/GestorUsuarios/userServlet" method="POST">
        <label for="nombre">Nombre</label>
        <input type="text" name="nombre" id="nombre" required /> <br />
        <label for="edad">Edad</label>
        <input type="number" id="edad" name="edad" required /> <br />
        <label for="pais">Pais</label>
        <input type="text" name="pais" id="pais" required /> <br />

        <label for="role">Rol</label>
        <select name="role" id="role">
            <c:forEach var="rol" items="roles">
                <option value="${rol.nombre}"><c:out value="${rol.nombre}" /></option>
            </c:forEach>
        </select>
        <button type="submit">Agregar usuario</button>
    </form>
</body>
</html>