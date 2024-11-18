package com.modulocinco.modelo;

public class Usuario {

  private int idUser;
  private String nombre;
  private String correo;
  private String clave;
  private int idRol;
  private boolean estado;

  /* VAMOS A USAR SOBRECARGA DE METODOS */

  // Para recuperar usuarios
  public Usuario(int idUser, String nombre, String correo, String clave, int idRol, boolean estado) {
    this.idUser = idUser;
    this.nombre = nombre;
    this.correo = correo;
    this.clave = clave;
    this.idRol = idRol;
    this.estado = estado;
  }

  // Para crear usuarios
  public Usuario(String nombre, String correo, String clave, int idRol) {
    this.nombre = nombre;
    this.correo = correo;
    this.clave = clave;
    this.idRol = idRol;
  }

  public int getIdUser() {
    return this.idUser;
  }

  public void setIdUser(int idUser) {
    this.idUser = idUser;
  }

  public String getNombre() {
    return this.nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getCorreo() {
    return this.correo;
  }

  public void setCorreo(String correo) {
    this.correo = correo;
  }

  public String getClave() {
    return this.clave;
  }

  public void setClave(String clave) {
    this.clave = clave;
  }

  public int getIdRol() {
    return this.idRol;
  }

  public void setIdRol(int idRol) {
    this.idRol = idRol;
  }

  public boolean isEstado() {
    return this.estado;
  }

  public boolean getEstado() {
    return this.estado;
  }

  public void setEstado(boolean estado) {
    this.estado = estado;
  }


}
