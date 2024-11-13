package com.modulocinco.modelo;

public class Usuario {

  private String nombre;
  private int edad;
  private String pais;
  private Role role;

  public Usuario(String nombre, int edad, String pais, Role role) {
    this.nombre = nombre;
    this.edad = edad;
    this.pais = pais;
    this.role = role;
  }

  public String getNombre() {
    return this.nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public int getEdad() {
    return this.edad;
  }

  public void setEdad(int edad) {
    this.edad = edad;
  }

  public String getPais() {
    return this.pais;
  }

  public void setPais(String pais) {
    this.pais = pais;
  }

  public Role getRole() {
    return role;
  }

  public void setRole(Role role) {
    this.role = role;
  }


}
