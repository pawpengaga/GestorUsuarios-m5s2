<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lista de roles</title>
</head>
<body>

    <h2>Lista de roles</h2>
    <br />
    <c:if test="${empty roles}">
        <p>No hay roles registrados...</p>
    </c:if>
    <c:if test="${not empty roles}">
        <ul>
            <c:forEach var="role" items="${roles}">
                <li><c:out value="${role.nombre}" /></li>
            </c:forEach>
        </ul>
    </c:if>
    
    <p><a href="index.jsp">Volver al inicio</a></p>



</body>
</html>