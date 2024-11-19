<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <!-- Import moderno -->
    <!-- <%@ taglib uri="jakarta.tags.core" prefix="c" %> -->
<!DOCTYPE html>
<html>
<head>
    <title>Listar Usuarios</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <!-- Font Awesome -->
    <link 
        rel="stylesheet"
        type="text/css" 
        href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css" 
        integrity="sha512-KFkfwYDsLkINwp0p6FLnBZNdLGxuY9AAIQwvINkS4PhcL9sVcqvYVLDD9aWkXd13uQJoXtEKNosOwaZqXgeLog==" 
        crossorigin="anonymous" 
        referrerpolicy="no-referrer">

    <!-- Bootstrap CSS -->
    <link 
        href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" 
        rel="stylesheet" 
        integrity="sha384-QWTkZ9jpPEjISv5IAkWRU9OFRe0R6YctnYmDr5pNYjTbZrjXHqJY6hHALEwIH" 
        crossorigin="anonymous">

    <!-- CSS Personalizado -->
    <link rel="stylesheet" href="assets/css/estilos.css">
    </head>
<body>
    <!-- Aqui vamos tener un ciclo con JSTL -->
    <br />
    <c:if test = "${empty usuarios}" >
        <p>No hay usuarios registrados...</p>
    </c:if>
    <c:if test = "${not empty usuarios}" >
        <table border="1">
            <tr>
                <th>Id</th>
                <th>Nombre</th>
                <th>Correo</th>
                <th>Rol</th>
                <th>Acciones ???</th>
            </tr>
            <!-- Status es un objeto que tiene muchos atributos, uno de estos atributos es index -->
            <c:forEach var="usuario" items="${usuarios}" varStatus="status">
                <tr>
                    <td><c:out value="${usuario.idUser}" /></td>
                    <td><c:out value="${usuario.nombre}" /></td>
                    <td><c:out value="${usuario.correo}" /></td>
                    <td>
                        <c:out value="${usuario.rol_nombre}" />
                        <!-- Aqui deberian haber mas cosas -->
                    </td>
                    <td>
                        <a href="/GestorUsuarios/userServlet?accion=detalle&indice=${usuario.idUser}">Ver detalle</a> <br>
                        <a href="/GestorUsuarios/userServlet?accion=eliminar&indice=${usuario.idUser}">Ver detalle</a> <br>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <!-- Aqui deberia un boton para nuevo usuario -->
    </c:if>
    <div>
        <form action="/GestorUsuarios/userServlet" method="POST">
            <input type="text" name="nombre" placeholder="nombre"> <br>
            <input type="email" name="correo" placeholder="correo"> <br>
            <input type="password" name="clave" placeholder="clave"> <br>
            <input type="text" name="rolUsuario" placeholder="rol"> <br>
            <select name="rolUsuario" id="rolUsuario">
                <option value="">Seleccione un rol</option>
                <c:forEach var="role" items="${roles}">
                    <option value="${role.id_rol}">${role.nombre}</option>
                </c:forEach>
            </select> <br>
        </form>
    </div>
    <p><a href="index.jsp">Volver al inicio</a></p>
</body>
</html>