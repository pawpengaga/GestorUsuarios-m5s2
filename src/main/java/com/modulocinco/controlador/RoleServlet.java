package com.modulocinco.controlador;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.modulocinco.dao.RoleDAO;
import com.modulocinco.modelo.Role;

/**
 * Servlet implementation class RoleServlet
 */
@WebServlet("/RoleServlet")
public class RoleServlet extends HttpServlet {

	/*
	 * Los servlet pertenecen al controlador
	 */

	private static final long serialVersionUID = 1L;

	private RoleDAO roleDAO = new RoleDAO();

	public RoleServlet(){
		// Hemos vuelto a un constructor normal
		super();
	}

	//private List<Role> roles;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    // public RoleServlet() {
    //     super();
		// 		roles = new ArrayList<>();
    // }
		// VAMOS A CAMBIAR UN CONSTRUCTOR POR UN INICIALIZADOR
		// public void init() throws ServletException {
		// 	// Cuando generamos algo a nivel de contexto, se convierte en una variable global a todo el sistema
		// 	super.init();
		// 	if (getServletContext().getAttribute("roles") == null) {
		// 		getServletContext().setAttribute("roles", new ArrayList<>());
		// 	} else {
		// 		System.out.println((List<Role>) getServletContext().getAttribute("roles"));
		// 	}
		// }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);
		// Si la sesion del usuario es nula, se manda al login
		// Antes de cualquier accion
		if (session == null || session.getAttribute("usuario") == null) {
			response.sendRedirect("login.jsp");
			return;
		} else {
			System.out.println("Valor sesion" + session.getAttribute("usuario").toString());
		}
		String accion = request.getParameter("accion");

		if(accion.equals("listar")){
		try {
				List<Role> rolesLista = roleDAO.getRoles();
				// Usamos el mismo esquema de definir acciones
				request.setAttribute("rolesLista", rolesLista);
				// Aqui creamos el set de roles para mandarlo al jsp
				// La lista de roles mandada por medio de esto es lo que mandamos al jsp para que lo itere con JSTL
				// request.setAttribute("roles", roles);
				request.getRequestDispatcher("listarRole.jsp").forward(request, response);
			} catch (Exception e){
				throw new ServletException("Error al obtener roles ",e);
			}
		} else if ("add".equals(accion)) {
			request.getRequestDispatcher("addRole.jsp").forward(request, response);
		} else if (accion.equals("edit")){
			int idRol = Integer.parseInt(request.getParameter("uid"));
			System.out.println(idRol);
		} else {
			request.getRequestDispatcher("listarRole.jsp").forward(request, response);
		}


	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String accion = request.getParameter("accion");
		String nombre = request.getParameter("nombre");

		if (accion.equals("add")) {
			try {
				roleDAO.addRole(nombre);
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
			response.sendRedirect("/GestorUsuarios/RoleServlet?accion=listar");
		} if (accion.equals("edit")){
			int idRol = Integer.parseInt(request.getParameter("uid"));
			System.out.println(idRol);

		} else {
			System.out.println("ESTE SISTEMA FUNCIONA");
		}

		// Codigo que ya no necesitamos por la DATABASE UPDATE

		// List<Role> roles = (List<Role>) getServletContext().getAttribute("roles");

		// roles.add(new Role(nombre));

		// getServletContext().setAttribute("roles", roles);
		// response.sendRedirect("/GestorUsuarios/RoleServlet?accion=listar");

	}

	// public List<Role> getRoles(){
	// 	return roles;
	// }

}
