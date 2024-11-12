package com.modulocinco.modelo;

public class Usuario {

  private String nombre;
  private int edad;
  private String pais;

  public Usuario(String nombre, int edad, String pais) {
    this.nombre = nombre;
    this.edad = edad;
    this.pais = pais;
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

  @Override
  public String toString() {
    return "{" +
      " nombre='" + getNombre() + "'" +
      ", edad='" + getEdad() + "'" +
      ", pais='" + getPais() + "'" +
      " }";
  }


}
