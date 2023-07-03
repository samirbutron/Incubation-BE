package com.mx.entidad;

public class Alumno {
  private String curp;
  private String nombre;
  private String apellido;
  private int edad;

  public Alumno() {
  }

  public Alumno(String curp) {
    this.curp = curp;
  }

  public Alumno(String curp, String nombre, String apellido, int edad) {
    this.curp = curp;
    this.nombre = nombre;
    this.apellido = apellido;
    this.edad = edad;
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

  @Override
  public String toString() {
    return "Alumno{" +
        "curp='" + curp + '\'' +
        ", nombre='" + nombre + '\'' +
        ", apellido='" + apellido + '\'' +
        ", edad=" + edad +
        '}';
  }
}
