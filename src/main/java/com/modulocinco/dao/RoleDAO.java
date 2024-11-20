package com.modulocinco.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.modulocinco.conf.DatabaseConnection;
import com.modulocinco.modelo.Role;

public class RoleDAO {

  /*
   * Los DAO pertenecen al modelo
   * Trabajan la linea de negocio y la persistencia
   */

  // VERSION ANOTADA HECHA POR MI (temporalmente retirada)

  // public List<String> getRoles() throws SQLException{
    
  //   List<String> roles = new ArrayList<>();
  //   // Cuando las consultas son muy complejas, primero se prueban en el motor
  //   String query = "SELEC nombre FROM roles WHERE estado != false"; // Traemos todos los estados diferentes de falso

  //   Connection conn = null;
  //   PreparedStatement stmt = null;

  //   try{
  //     Connection conn = DatabaseConnection.getConnection();
  //       PreparedStatement stmt = conn.prepareStatement(query); // Se le ejectuta el query al statement
  //       // rs el conjunto resultado de la consulta, trae varias filas
  //       ResultSet rs = stmt.executeQuery();
  //         // Mientras que tenga un siguiente, se añaden los datos a la lista
  //         while (rs.next()) {
  //           // Se traen los resultados de la columna nombre y se convierten a String
  //           roles.add(rs.getString("nombre"));
  //         }
  //   }
  //   // Se retorna la lista con nombres obtenidos a la manera de Java
  //   return roles;

  // }

  // VERSION SIN ANOTACIONES HECHA POR EL PROFESOR

  /*
   * Statement se puede usar para SELECTS
   * PreparedStatement se puede usar para DELETE, UPDATE, etc.
   */

	public List<Role> getRoles() throws SQLException {
		List<Role> roles = new ArrayList<>();
		String query = "SELECT \"idRol\", nombre, estado FROM roles WHERE estado != false";
		Connection conn = null;
    PreparedStatement stmt = null;
		try {
			conn = DatabaseConnection.getConnection();
			if(conn == null) {
        		throw new SQLException("No se puedo establecer la conexión con la base de datos");
        	}
			stmt = conn.prepareStatement(query);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				roles.add(new Role(rs.getInt("idRol"), rs.getString("nombre"), rs.getBoolean("estado")));
			}
			System.out.println("Listo Roles con exito");
		}finally {
        	System.out.println("Listo Roles");
        }
		return roles;
	}

  public void addRole(String roleName) throws SQLException {
    // Aqui tenemos la query
    String query = "INSERT INTO roles (nombre) VALUES (?)";

    // Version de multiples campos
    // String query = "INSERT INTO roles (nombre, estado) VALUES (?, ?)";
    
    Connection conn = null; // Se crea la conexion
    PreparedStatement stmt = null; // Se crea el statement

    try {
        conn = DatabaseConnection.getConnection();

        if (conn == null) {
            throw new SQLException("No se pudo establecer la conexión con la base de datos para agregar");
        }
        // Todo esto ocurre si la conexion NO es nula, recien aqui se ejecuta la query
        stmt = conn.prepareStatement(query);
        stmt.setString(1, roleName);

        // Si existieran mas campos en la consulta (Linea 40), este seria el set para el segundo
        // Cada set es distinto para cada tipo de dato
        // stmt.setBoolean(2, true);
        
        stmt.executeUpdate(); // Tambien se usa .executeQuery()
    } catch (SQLException e) {
      System.err.println("No se pudo conectar para agregar en el catch " + e.getMessage());
    } finally {
        System.out.println("Agregar Rol");
    }
  }

  public void deleteRole(int roleId) throws SQLException {

    // No cambia mucho para el metodo delete
    String query = "DELETE FROM roles WHERE idRol = ?";
    
    try (Connection connection = DatabaseConnection.getConnection();
        PreparedStatement stmt = connection.prepareStatement(query)) {
        stmt.setInt(1, roleId);
        stmt.executeUpdate();
    }
  }

}
