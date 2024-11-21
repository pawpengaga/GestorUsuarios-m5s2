<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- Import moderno -->
<!-- <%@ taglib uri="jakarta.tags.core" prefix="c" %> -->
<!DOCTYPE html>
<html>
<!-- Vale por la etiqueta head -->
<%@ include file="header.jsp" %>
<body>
    <!-- Aqui vamos tener un ciclo con JSTL -->
    <br />
    <c:if test="${empty users}" >
        <p>No hay usuarios registrados...</p>
    </c:if>
    <c:if test="${not empty users}" >
        <table class="table table-striped">
            <tr>
                <th>Id</th>
                <th>Nombre</th>
                <th>Correo</th>
                <th>Rol</th>
                <th>Acciones ???</th>
            </tr>
            <!-- Status es un objeto que tiene muchos atributos, uno de estos atributos es index -->
            <c:forEach var="usuario" items="${users}" varStatus="status">
                <tr>
                    <td><c:out value="${usuario.idUser}" /></td>
                    <td><c:out value="${usuario.nombre}" /></td>
                    <td><c:out value="${usuario.correo}" /></td>
                    <td>
                        <c:out value="${usuario.nombreRol}" />
                        <!-- Aqui deberian haber mas cosas -->
                    </td>
                    <td class="d-flex flex-row gap-3">
                        <a class="btn btn-outline-dark" href="/GestorUsuarios/userServlet?accion=detalle&indice=${usuario.idUser}">Ver</a> <br>
                        <a class="btn btn-outline-dark" href="/GestorUsuarios/userServlet?accion=eliminar&indice=${usuario.idUser}">Eliminar</a> <br>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <!-- Aqui deberia un boton para nuevo usuario -->
    </c:if>
    <p><a href="index.jsp">Volver al inicio</a></p>
</body>
</html>