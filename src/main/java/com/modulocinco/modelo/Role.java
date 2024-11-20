package com.modulocinco.modelo;

public class Role {

  private int id_rol;
  private String nombre;
  private boolean estado;


  public Role(int id_rol, String nombre, boolean estado) {
    this.id_rol = id_rol;
    this.nombre = nombre;
    this.estado = estado;
  }

  public int getId_rol() {
    return this.id_rol;
  }

  public void setId_rol(int id_rol) {
    this.id_rol = id_rol;
  }

  public String getNombre() {
    return this.nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
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
