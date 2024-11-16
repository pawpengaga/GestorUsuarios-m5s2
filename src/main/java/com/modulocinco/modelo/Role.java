package com.modulocinco.modelo;

public class Role {

  private String nombre;

  public Role(String nombre) {
    this.nombre = nombre;
  }

  public String getNombre() {
    return this.nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

@Override
public String toString() {
	return nombre;
}
  
  

}
