<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    <%@ taglib uri="jakarta.tags.core" prefix="c" %>
    <%@ page import="jakarta.servlet.http.Cookie" %>
    <%@ page import="jakarta.servlet.http.HttpSession" %>
    <%
    String usuario = null;
    Cookie[] cookies = request.getCookies();
    if(cookies != null){
        for(Cookie cookie : cookies){
            if("usuario".equals(cookie.getName())){
                usuario = cookie.getValue();
                break;
            }
        }
    }
    %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Gestor Usuarios</title>
    <link rel="stylesheet" href="css/style.css">
</head>