package com.modulocinco.controlador;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.modulocinco.modelo.Role;

/**
 * Servlet implementation class RoleServlet
 */
@WebServlet("/RoleServlet")
public class RoleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private List<Role> roles = new ArrayList<>();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RoleServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// Usamos el mismo esquema de definir acciones
		String accion = request.getParameter("accion");
		if(accion.equals("listar")){
			// Aqui creamos el set de roles para mandarlo al jsp
			// La lista de roles mandada por medio de esto es lo que mandamos al jsp para que lo itere con JSTL
			request.setAttribute("roles", roles);
			request.getRequestDispatcher("listarRole.jsp").forward(request, response);
		} else {
			// Sino mandamos la redireccion sin manipular nada de la request
			request.getRequestDispatcher("addRole.jsp").forward(request, response);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String nombre = request.getParameter("nombre");
		roles.add(new Role(nombre));



	}

}
