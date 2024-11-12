<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Gestor Usuarios</title>
</head>
<body>
    <h2>Agrega usuarios</h2>
    <br />
    <form action="GestorUsuarios/userServlet" method="POST">
        <label for="nombre">Nombre:</label>
        <input type="text" name="nombre" id="nombre" required /> <br />
        <label for="edad">Edad:</label>
        <input type="number" id="edad" name="edad" required /> <br />
        <label for="pais">Pais</label>
        <input type="text" name="pais" id="pais" required /> <br />
        <button type="submit">Agregar usuario</button>
    </form>
</body>
</html>