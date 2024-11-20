package com.modulocinco.controlador;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.modulocinco.dao.RoleDAO;
import com.modulocinco.dao.UserDAO;
import com.modulocinco.modelo.Role;
import com.modulocinco.modelo.Usuario;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class userServlet
 */
@WebServlet("/userServlet")
public class userServlet extends HttpServlet {

	/*
	 * Los servlet pertenecen al controlador
	 */
	
	private static final long serialVersionUID = 1L;
	

	private List<Usuario> usuarios = new ArrayList<>();
	private UserDAO userDAO = new UserDAO();
	private RoleDAO roleDAO = new RoleDAO();
	// private RoleServlet roleServlet = new RoleServlet();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public userServlet() {
        super();
    }

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
		}

		String accion = request.getParameter("accion");

		

		if(accion.equals("listar")){

			try {
				listUsers(request, response);
			} catch (SQLException e){
				System.err.println(e.getMessage());
			}

		} else if (accion.equals("detalle")) {

			int indice = Integer.parseInt(request.getParameter("indice"));
			Usuario user = usuarios.get(indice);
			request.setAttribute("usuario", user);
			request.getRequestDispatcher("detalleUsuario.jsp").forward(request, response);

		} else if (accion.equals("add")) {
			List<Role> listado = (List<Role>) getServletContext().getAttribute("roles");
			System.out.println(listado);

			request.setAttribute("xroles", listado);
			request.getRequestDispatcher("addUser.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Ahora hacemos nuestro metodo POST
		// String nombre = request.getParameter("nombre");
		// int edad = Integer.parseInt(request.getParameter("edad"));
		// String pais = request.getParameter("pais");
		// String roleName = request.getParameter("role");

		// List<Role> listado = (List<Role>) getServletContext().getAttribute("roles");

		// Role role = listado.stream().filter(r -> r.getNombre().equals(roleName)).findFirst().orElse(null);

		// usuarios.add(new Usuario(nombre, edad, pais, role));
		
		/* PARTIMOS DE NUEVO */

		String accion = request.getParameter("accion");
		if (accion == null) {
			try {
				addUser(request, response);
			} catch (SQLException e){
				System.err.println(e.getMessage());
			}
		} else {
			try {
				switch (accion) {
					case "update" -> updateUser(request, response);
					case "delete" -> deleteUser(request, response);
					default -> listUsers(request, response);
				}
			} catch (SQLException e){
				System.err.println(e.getMessage());
			}
		}

		response.sendRedirect("/GestorUsuarios/userServlet?accion=listar");

	}

	private void addUser(HttpServletRequest request, HttpServletResponse response) throws SQLException{
		String nombre = request.getParameter("nombre");
		String correo = request.getParameter("correo");
		String clave = request.getParameter("clave");
		int idRol = Integer.parseInt(request.getParameter("idRol"));

		Usuario newUser = new Usuario();
		newUser.setNombre(nombre);
		newUser.setCorreo(correo);
		newUser.setClave(clave);
		newUser.setIdRol(idRol);

		userDAO.addUser(newUser);
	}

	private void updateUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException{
		int idUser = Integer.parseInt(request.getParameter("idUser"));
		String nombre = request.getParameter("nombre");
		String correo = request.getParameter("correo");
		String clave = request.getParameter("clave");
		int idRol = Integer.parseInt(request.getParameter("idRol"));
		boolean estado = Boolean.valueOf(request.getParameter("estado"));

		Usuario newUser = new Usuario();
		newUser.setNombre(nombre);
		newUser.setCorreo(correo);
		newUser.setClave(clave);
		newUser.setIdRol(idRol);
		newUser.setEstado(estado);
		
		userDAO.addUser(newUser);
		response.sendRedirect("listarUsuarios.jsp");

	}

	private void deleteUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException{
		int idUser = Integer.parseInt(request.getParameter("idUser"));
	
		// Le pasamos el id al DAO
		userDAO.eliminarUser(idUser);

		response.sendRedirect("listarUsuarios.jsp");
	}

	private void listUsers(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		List<Usuario> users = userDAO.getUsers();
		List<Role> roles = roleDAO.getRoles();

		request.setAttribute("users", users);
		request.setAttribute("roles", roles);

		request.getRequestDispatcher("listarUsuarios.jsp").forward(request, response);
	}


}
