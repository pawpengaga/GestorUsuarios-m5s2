<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <!-- Import moderno -->
    <!-- <%@ taglib uri="jakarta.tags.core" prefix="c" %> -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Listar Usuarios</title>
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
                <th>Nombre</th>
                <th>Edad</th>
                <th>Pais</th>
                <th>Detalle</th>
            </tr>
            <!-- Status es un objeto que tiene muchos atributos, uno de estos atributos es index -->
            <c:forEach var="usuario" items="${usuarios}" varStatus="status">
                <tr>
                    <td><c:out value="${usuario.nombre}" /></td>
                    <td><c:out value="${usuario.edad}" /></td>
                    <td><c:out value="${usuario.pais}" /></td>
                    <td><a href="/GestorUsuarios/userServlet?accion=detalle&indice=${status.index}">Ver detalle</a></td>
                </tr>
            </c:forEach>
        </table>
    </c:if>
    <p><a href="index.jsp">Volver al inicio</a></p>
</body>
</html>