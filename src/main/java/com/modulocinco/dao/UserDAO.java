package com.modulocinco.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.modulocinco.conf.DatabaseConnection;
import com.modulocinco.modelo.Usuario;

public class UserDAO {

  public List<Usuario> getUsers(){
    List<Usuario> usuarios = new ArrayList<>();
    // Se dice que el user es distinto de false por como funciona el preparedstatement
    String consulta = "SELECT * FROM usuarios WHERE id_user != false";
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
        usuarios.add(new Usuario(rs.getInt("id_user"), rs.getString("nombre"), rs.getString("correo"), rs.getString("clave"), rs.getInt("id_rol"), rs.getBoolean("estado")));
      }

    } catch (SQLException e) {
      e.printStackTrace();
    }
    return usuarios;
  }

}
