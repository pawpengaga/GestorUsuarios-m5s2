package com.modulocinco.controlador;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * Servlet implementation class AuthServlet
 */

@WebServlet("/AuthServlet")
public class AuthServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AuthServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Recuepramos lo que envia el form (datos)
		String usuario = request.getParameter("usuario");
		String clave = request.getParameter("clave");

		// Se valida la veracidad de los datos
		// La clave va a ser 1234
		if("admin".equals(usuario) && "1234".equals(clave)){
			// Se crea la sesion y se establece el nombre de usuario (Aun sin atributos)

			/*
			 * 
			 * Las sesiones son GLOBALES
			 * Pueden ser accedidas desde cualquier vista
			 * No requieren pasarse a la response
			 */
			HttpSession session = request.getSession();
			session.setAttribute("usuario", usuario); // Se ponen los atributos a la session			
			
			Cookie userCookie = new Cookie("usuario", usuario); // Se crea un cookie para guardar la sesion en la maquina en lugar de en la aplicacion Java. Las cookies funcionan por un sistema de clave valor
			userCookie.setMaxAge(60*60); // Se le asigna un tiempo de vida a la sesion

			
			response.addCookie(userCookie); // Se envia junto con la respuesta
			response.sendRedirect("index.jsp"); // Se hace la redireccion

		} else {
			response.sendRedirect("login.jsp?error=invalid"); // Si los datos fueron incorrectos se redirecciona junto con un dato extra por medio de GET
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
