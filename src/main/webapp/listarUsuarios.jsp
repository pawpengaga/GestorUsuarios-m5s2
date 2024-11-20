<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <!-- Import moderno -->
    <!-- <%@ taglib uri="jakarta.tags.core" prefix="c" %> -->
<!DOCTYPE html>
<html>
<!-- Vale por la etiqueta head -->
<%@ include file="header.jsp" %>
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