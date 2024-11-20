<%@ include file="header.jsp" %>
<body id="index">

    <!-- 
    - Todo lo que existe en webapp son las vistas
    -->

	<div>
        <h1>Bienvenido, <c:out value="${usuario}" default="INVITADO" /></h1>
            <%
            // HttpSession session = request.getSession(false); // La s extra fue quitada...
            if (session.getAttribute("usuario") == null) { %>
                <ul>
                    <li><a href="logout.jsp">Iniciar sesion</a></li>
                </ul>
			    <%@ include file="button.jsp" %>
            <% } %>
        <br />
        <% if (session.getAttribute("usuario") != null) { %>
            <ul>
                <li><a href="/GestorUsuarios/RoleServlet?accion=add">Agregar Rol</a></li>
                <li><a href="/GestorUsuarios/userServlet?accion=listar">Listar usuarios</a></li>
                <li><a href="/GestorUsuarios/userServlet?accion=add">Agregar usuarios</a></li>
                <li><a href="logout.jsp">Cerrar Sesion</a></li>
                    <!-- <li><a href="logout.jsp">Cerrar Sesión</a></li> -->
                    <!-- <c:out value="${usuario}" default="INVITADO" /> -->
			    <%@ include file="button.jsp" %>
            </ul>
        <% } %>
    </div>
	
</body>
</html>