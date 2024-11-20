<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<!-- Vale por la etiqueta head -->
<%@ include file="header.jsp" %>
<body>
    
    <div class="container mt-5">
        <h2>Lista de roles</h2>
        <c:if test="${empty rolesLista}">
            <p>No hay roles registrados...</p>
        </c:if>
        <table class="table table-striped">
            <thead>
                <tr>
                    <th>Id rol</th>
                    <th>Nombre de rol</th>
                    <th>Estado</th>
                    <th>Acciones</th>
                </tr>
            </thead>
            <tbody>
                <c:if test="${not empty rolesLista}">
                        <c:forEach var="myrole" items="${rolesLista}">
                            <!-- Ahora que traemos el objeto desde la base de datos de forma personalizada, no hace falta usar sintaxis de punto, los datos son los que son -->
                            <tr>
                                <td><c:out value="${myrole.id_rol}" /></td>
                                <td><c:out value="${myrole.nombre}" /></td>
                                <td><c:out value="${myrole.estado ? 'Activo' : 'Inactivo'}" /></td>
                                <td><a class="btn btn-dark" href="/GestorUsuarios/RoleServlet?accion=edit&uid=${myrole.id_rol}">Editar</a></td>
                            </tr>
                        </c:forEach>
                </c:if>
            </tbody>
        </table>
        
        <p><a href="index.jsp">Volver al inicio</a></p>
    </div>



</body>
</html>