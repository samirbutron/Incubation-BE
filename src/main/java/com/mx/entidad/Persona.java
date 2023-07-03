package com.mx.entidad;

import java.util.ArrayList;
import java.util.List;

public class Persona {
  private String curp;
  private String nombre;
  private String apellido;
  private int edad;
  private String ciudad;
  private List<Mascota> mascotaList = new ArrayList<>();

  public Persona() {
  }

  //LLave de esta clase
  public Persona(String curp) {
    this.curp = curp;
  }

  public Persona(String curp, String nombre, String apellido, int edad, String ciudad) {
    this.curp = curp;
    this.nombre = nombre;
    this.apellido = apellido;
    this.edad = edad;
    this.ciudad = ciudad;
  }

  public String getCurp() {
    return curp;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getApellido() {
    return apellido;
  }

  public void setApellido(String apellido) {
    this.apellido = apellido;
  }

  public int getEdad() {
    return edad;
  }

  public void setEdad(int edad) {
    this.edad = edad;
  }

  public String getCiudad() {
    return ciudad;
  }

  public void setCiudad(String ciudad) {
    this.ciudad = ciudad;
  }

  public List<Mascota> getMascotaList() {
    return mascotaList;
  }

  public void setMascotaList(List<Mascota> mascotaList) {
    this.mascotaList = mascotaList;
  }

  @Override
  public String toString() {
    return "Persona{" +
        "curp='" + curp + '\'' +
        ", nombre='" + nombre + '\'' +
        ", apellido='" + apellido + '\'' +
        ", edad=" + edad +
        ", ciudad='" + ciudad + '\'' +
        ", mascotaList=" + mascotaList +
        '}';
  }
}
