package com.modulocinco.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.modulocinco.conf.DatabaseConnection;
import com.modulocinco.modelo.Usuario;

public class UserDAO {

  /*
   * Los DAO pertenecen al modelo
   * Trabajan la linea de negocio y la persistencia
   */

  public List<Usuario> getUsers(){
    List<Usuario> usuarios = new ArrayList<>();
    // CORRECCION: Fue un error de tipeo, se refiere a la busqueda del estado
    String consulta = "SELECT u.\"idUser\", u.nombre, u.correo, u.\"idRol\", r.nombre AS rol_nombre FROM usuarios u INNER JOIN roles r ON u.\"idRol\" = r.\"idRol\" WHERE u.estado != false ORDER BY u.\"idUser\"";
    Connection conn = null;
    PreparedStatement stmt = null;
    // Statement stmt = null;
    try {
      // Dentro del Try vamos a crear la conexion
      conn = DatabaseConnection.getConnection();
      if(conn == null){
        throw new SQLException("Problemas con conexion a la base de datos USUARIOS");
      }
      stmt = conn.prepareStatement(consulta);
      ResultSet rs = stmt.executeQuery();

      while (rs.next()) {
        // Llenamos nuestra lista con lo que leemos de la base de datos
        Usuario user = new Usuario();
        user.setIdUser(rs.getInt("idUser"));
        user.setNombre(rs.getString("nombre"));
        user.setCorreo(rs.getString("correo"));
        user.setIdRol(rs.getInt("idRol"));
        user.setNombreRol(rs.getString("rol_nombre"));
        usuarios.add(user);
      }
      System.out.println("Usuarios listado con exito");
      // Cerramos el resourceSet
      rs.close();
      // Cerramos nuestra declaracion
      stmt.close();

    } catch (SQLException e) {
      e.printStackTrace();
    }
    return usuarios;
  }

  public Usuario getUser(int idUser) {
    Usuario user = null;
    String consulta = "SELECT u.id_user, u.nombre, u.correo, u.\"idRol\", r.nombre AS rol_nombre FROM usuarios u INNER JOIN roles r ON u.id_rol = r.id_rol WHERE estado != false AND u.id_user = " + idUser;
    Connection conn = null;

    try {
      conn = DatabaseConnection.getConnection();
      if (conn == null) {
          throw new SQLException("No se puede establecer la conexión con la base de datos");
      }

      Statement stmt = conn.createStatement();
      
      // ResultSet se usa para almacenar lo conseguido en sentencias SELECT
      ResultSet rs = stmt.executeQuery(consulta);

      if (rs.next()) {
        user = new Usuario();
        user.setIdUser(rs.getInt("id_user"));
        user.setNombre(rs.getString("nombre"));
        user.setCorreo(rs.getString("correo"));
        user.setIdRol(rs.getInt("id_rol"));
        user.setNombreRol(rs.getString("rol_nombre"));
        user.setEstado(rs.getBoolean("estado"));
      }

      rs.close();
      stmt.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return user;
}

  public void addUser(Usuario user) throws SQLException{
    String sql = "INSERT INTO usuarios (nombre, correo, clave, \"idRol\") VALUES (?,?,?,?)";
    Connection conn = null;
    PreparedStatement stmt = null;
    try {
      conn = DatabaseConnection.getConnection();
      if (conn == null) {
          throw new SQLException("No se puede establecer la conexión con la base de datos USUARIOS");
      }

      // Contruimos la insercion de datos
      stmt = conn.prepareStatement(sql);
      stmt.setString(1, user.getNombre());
      stmt.setString(2, user.getCorreo());
      stmt.setString(3, user.getClave());
      stmt.setInt(4, user.getIdRol());

      // Devuelve true or false si la ejecucion fue exitosa
      if (!stmt.execute()) {
        System.out.println("Usuario creado");
      } else {
        System.out.println("Usuario fallo al crearse");
      }

      stmt.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
  }

  public void updateUser(Usuario user){
    String sql = "UPDATE usuarios SET nombre=?, correo=?, clave=?, id_rol=?, estado=?";
    Connection conn = null;
    PreparedStatement stmt = null;
    try {
      conn = DatabaseConnection.getConnection();
      if (conn == null) {
          throw new SQLException("No se puede establecer la conexión con la base de datos USUARIOS");
      }

      // Contruimos la insercion de datos
      stmt = conn.prepareStatement(sql);
      stmt.setString(1, user.getNombre());
      stmt.setString(2, user.getCorreo());
      stmt.setString(3, user.getClave());
      stmt.setInt(4, user.getIdRol());
      stmt.setBoolean(5, user.getEstado());

      /*
       * Devuelve un entero que corresponde al numero de filas/columnas afectadas
       * (Ver como pgadmin y similares devuelven el valor)
       * Si falla devolvera un 0 o un -1
       * Se puede almacenar dentro de una variable
       */
      if (stmt.executeUpdate() > 0) {
        System.out.println("Usuario actualizado con exito");
      } else {
        System.out.println("Fallo la actualizacion...");
      }

      stmt.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
  }

  public void eliminarUser(int idUser) {
    String query = "DELETE FROM usuarios WHERE id_user = ?";
    Connection conn = null;
    PreparedStatement stmt = null;

    try {
        conn = DatabaseConnection.getConnection();
        if (conn == null) {
            throw new SQLException("No se puede establecer la conexión con la base de datos");
        }

        stmt = conn.prepareStatement(query);
        stmt.setInt(1, idUser);

        int fila = stmt.executeUpdate();

        if (fila > 0) {
            System.out.println("Se eliminó el usuario con éxito");
        } else {
            System.out.println("Problema al eliminar el usuario");
        }

        stmt.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}




}
