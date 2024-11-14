<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Gestor Usuarios</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
	<h1>Bienvenido</h1>
	<br />
    <ul>
        <li><a href="addRole.jsp">Agregar Rol</a></li>
        <li><a href="/GestorUsuarios/userServlet?accion=listar">Listar usuarios</a></li>
        <li><a href="/GestorUsuarios/userServlet?accion=add">Agregar usuarios</a></li>
    </ul>
	
</body>
</html>