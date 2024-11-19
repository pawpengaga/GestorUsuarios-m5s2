package com.modulocinco.modelo;

public class Usuario {

  private int idUser;
  private String nombre;
  private String correo;
  private String clave;
  // Debido a que la relacion existe en las tablas, es mejor trabajar aqui con 2 atributos simples que con uno complejo
  private int idRol;
  private String nombreRol;
  private boolean estado;

  /* VAMOS A USAR SOBRECARGA DE METODOS */

  

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

  public String getNombreRol() {
    return this.nombreRol;
  }

  public void setNombreRol(String nombreRol) {
    this.nombreRol = nombreRol;
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
