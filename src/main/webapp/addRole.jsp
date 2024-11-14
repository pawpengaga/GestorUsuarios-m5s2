<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- <%@ taglib uri="jakarta.tags.core" prefix="c" %> -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Agregar roles</title>
</head>
<body>

    <h2>Agrega un rol nuevo</h2>
    <form action="/GestorUsuarios/RoleServlet" method="POST">
        <label for="nombre">Nombre de rol</label>
        <input type="text" id="nombre" name="nombre" required /> <br />
        <button type="submit">Agregar rol</button>
    </form>

</body>
</html>