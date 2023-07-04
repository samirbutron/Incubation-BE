package com.mx.entidad;

import java.util.Date;

public class Medico extends Persona{
  private String area;
  private String cargo;

  public Medico() {
  }

  public Medico(String nombre, String apellido, String genero, Date fechaNacimiento,
      double sueldo, String area, String cargo) {
    super(nombre, apellido, genero, fechaNacimiento, sueldo);
    this.area = area;
    this.cargo = cargo;
  }

  public String getArea() {
    return area;
  }

  public void setArea(String area) {
    this.area = area;
  }

  public String getCargo() {
    return cargo;
  }

  public void setCargo(String cargo) {
    this.cargo = cargo;
  }

  @Override
  public String toString() {
    return "Medico{" +
        "area='" + area + '\'' +
        ", cargo='" + cargo + '\'' +
        "} " + super.toString();
  }

  @Override
  public double sueldoNeto() {
    return getSueldo() - (getSueldo()*0.10);
  }
}
