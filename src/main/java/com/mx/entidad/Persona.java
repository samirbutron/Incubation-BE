package com.mx.entidad;

import java.util.Date;

public abstract class Persona{

  private String nombre;
  private String apellido;
  private String genero;
  private Date fechaNacimiento;
  private double sueldo;

  public Persona() {
  }

  public Persona(String nombre, String apellido, String genero, Date fechaNacimiento,
      double sueldo) {
    this.nombre = nombre;
    this.apellido = apellido;
    this.genero = genero;
    this.fechaNacimiento = fechaNacimiento;
    this.sueldo = sueldo;
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

  public String getGenero() {
    return genero;
  }

  public void setGenero(String genero) {
    this.genero = genero;
  }

  public Date getFechaNacimiento() {
    return fechaNacimiento;
  }

  public void setFechaNacimiento(Date fechaNacimiento) {
    this.fechaNacimiento = fechaNacimiento;
  }

  public double getSueldo() {
    return sueldo;
  }

  public void setSueldo(double sueldo) {
    this.sueldo = sueldo;
  }

  @Override
  public String toString() {
    return "Persona{" +
        "nombre='" + nombre + '\'' +
        ", apellido='" + apellido + '\'' +
        ", genero='" + genero + '\'' +
        ", fechaNacimiento=" + fechaNacimiento +
        ", sueldo=" + sueldo +
        '}';
  }

  public abstract double sueldoNeto();
}
