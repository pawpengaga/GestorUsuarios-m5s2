package com.modulocinco.conf;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

  private static final String URL = "jdbc:postgresql:/localhost:5432/db_pruebas";
  private static final String USER = "postgres";
  private static final String PASSWORD = "12345678";
  private static Connection cnx = null;

  private DatabaseConnection(){
    try {
      // Esto es para forzar la conexion entre comillas no lo
      Class.forName("org.postgresql.Driver");
      // cnx = DriverManager.getConnection(URL, USER, PASSWORD);
      cnx = DriverManager.getConnection("jdbc:postgresql:db_pruebas?user=postgres&password=12345678");

      System.out.println("Cargo el driver...");

      if (cnx != null) {
        System.out.println("Conexion establecida");
      } else{
        System.out.println("Fallo la conexion");
      }
    } catch (SQLException e){
      e.printStackTrace();
    } catch (ClassNotFoundException e){
      System.out.println(e.getMessage());
    }
  }

  public static Connection getConnection(){
    if (cnx == null) {
      new DatabaseConnection();
    }
    return cnx;
  }

  public static void main(String[] args) {
	 DatabaseConnection.getConnection();
  }


}
