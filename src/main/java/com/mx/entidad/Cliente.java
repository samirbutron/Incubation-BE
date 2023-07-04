package com.mx.entidad;

import java.util.ArrayList;
import java.util.List;

public class Cliente {

  private String curp;
  private String nombre;
  private String apellido;
  private int edad;
  private String ciudad;
  List<Cuenta> cuentaList = new ArrayList<>();

  public Cliente() {
  }

  public Cliente(String curp) {
    this.curp = curp;
  }

  public Cliente(String curp, String nombre, String apellido, int edad, String ciudad) {
    this.curp = curp;
    this.nombre = nombre;
    this.apellido = apellido;
    this.edad = edad;
    this.ciudad = ciudad;
  }

  public String getCiudad() {
    return ciudad;
  }

  public void setCiudad(String ciudad) {
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

  public List<Cuenta> getCuentaList() {
    return cuentaList;
  }

  public void setCuentaList(List<Cuenta> cuentaList) {
    this.cuentaList = cuentaList;
  }

  @Override
  public String toString() {
    return "Cliente{" +
        "curp='" + curp + '\'' +
        ", nombre='" + nombre + '\'' +
        ", apellido='" + apellido + '\'' +
        ", edad=" + edad +
        ", ciudad='" + ciudad + '\'' +
        ", cuentaList=" + cuentaList +
        '}';
  }
}
