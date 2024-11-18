package com.modulocinco.conf;

/*
 * PASOS PARA CONECTARSE A LA BASE DE DATOS
 * 1. Obtener la librería desde https://mvnrepository.com/artifact/org.postgresql/postgresql (Es un .jar)
 * 2. Dejar el .jar dento de la carpeta /GestorUsuarios/src/main/webapp/WEB-INF/lib/
 * 3. Ahora el proyecto es capaz de conectarse
 * 4. Se crea un paquete llamado conf (O cualquier nombre)
 * 5. Se crea una CLASE NORMAL de Java llamada DatabaseConnection (O cualquier nombre)
 * 6. Se escribe el siguiente codigo
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

  // 7. Las credenciales de acceso (Funciona mejor si la contraseña es un String)
  // private static final String URL = "jdbc:postgresql:/localhost:5432/db_pruebas";
  // private static final String USER = "postgres";
  // private static final String PASSWORD = 12345678;

  // 8. Se crea una conexión Nula para trabajarla dentro del metodo
  // 8.1 eSTE 
  private static Connection cnx = null;

  private DatabaseConnection(){
    try {
      // 9. Linea de codigo para forzar la conexación usando el .jar descargado
      Class.forName("org.postgresql.Driver");

      // 10. Metodos de conexión distintos, vamos a preferir el segundo que es un enlace de conexión directa con las credenciales dentro
      //cnx = DriverManager.getConnection(URL, USER, PASSWORD);
      cnx = DriverManager.getConnection("jdbc:postgresql:db_pruebas?user=postgres&password=12345678");

      System.out.println("Cargo el driver...");

      // Si la conexión no es nula, damos por hecho que fue exitosa
      if (cnx != null) {
        System.out.println("Conexion establecida");
      } else{
        System.out.println("Fallo la conexion");
      }
    // 11. Manejo de excepciones estándarar, podemos poner mas un tipo de catch segun el tipo de excepcion
    } catch (SQLException e){
      e.printStackTrace();
    } catch (ClassNotFoundException e){
      System.out.println(e.getMessage());
    }
  }

  // E
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
