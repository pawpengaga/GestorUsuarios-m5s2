package com.modulocinco.controlador;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.modulocinco.modelo.Role;
import com.modulocinco.modelo.Usuario;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class userServlet
 */
@WebServlet("/userServlet")
public class userServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private List<Usuario> usuarios = new ArrayList<>();
	private RoleServlet roleServlet = new RoleServlet();
       
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
		String accion = request.getParameter("accion");
		if(accion.equals("listar")){
			request.setAttribute("usuarios", usuarios);
			request.getRequestDispatcher("listarUsuarios.jsp").forward(request, response);
		} else if (accion.equals("detalle")) {

			int indice = Integer.parseInt(request.getParameter("indice"));
			Usuario user = usuarios.get(indice);
			request.setAttribute("usuario", user);
			request.getRequestDispatcher("detalleUsuario.jsp").forward(request, response);

		} else if (accion.equals("add")) {
			request.setAttribute("roles", roleServlet.getRoles());
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
		String nombre = request.getParameter("nombre");
		int edad = Integer.parseInt(request.getParameter("edad"));
		String pais = request.getParameter("pais");
		String roleName = request.getParameter("role");

		Role role = roleServlet.getRoles().stream().filter(r -> r.getNombre().equals(roleName)).findFirst().orElse(null);

		usuarios.add(new Usuario(nombre, edad, pais, role));
		response.sendRedirect("/GestorUsuarios/userServlet?accion=listar");

	}

}
