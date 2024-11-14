<%
	// Cierra la sesion
	session.invalidate();
	Cookie[] cookies = request.getCookies(); // Recupero las cookies grabadas
	if(cookies != null){
        for (Cookie cookie : cookies){
            if("usuario".equals(cookie.getName())){
                cookie.setMaxAge(0);
                response.addCookie(cookie);
            }
        }
	}
    response.sendRedirect("login.jsp");
	
%>