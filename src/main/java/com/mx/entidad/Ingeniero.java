package com.mx.entidad;

import java.util.Date;

public class Ingeniero extends Persona{
  private String especialidad;
  private String departamento;

  public Ingeniero(String nombre, String apellido, String genero, Date fechaNacimiento,
      double sueldo, String especialidad, String departamento) {
    super(nombre, apellido, genero, fechaNacimiento, sueldo);
    this.especialidad = especialidad;
    this.departamento = departamento;
  }

  public String getEspecialidad() {
    return especialidad;
  }

  public void setEspecialidad(String especialidad) {
    this.especialidad = especialidad;
  }

  public String getDepartamento() {
    return departamento;
  }

  public void setDepartamento(String departamento) {
    this.departamento = departamento;
  }

  @Override
  public String toString() {
    return "Ingeniero{" +
        "especialidad='" + especialidad + '\'' +
        ", departamento='" + departamento + '\'' +
        "} " + super.toString();
  }

  @Override
  public double sueldoNeto() {
    return  this.getSueldo() - (this.getSueldo()*0.20);
  }

}
