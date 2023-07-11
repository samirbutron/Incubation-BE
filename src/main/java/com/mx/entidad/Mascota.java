package com.mx.entidad;

public class Mascota {
  int no_registro;
  String nombre;
  int edad;
  double peso;

  public Mascota() {
  }

  public Mascota(int no_registro, String nombre, int edad, double peso) {
    this.no_registro = no_registro;
    this.nombre = nombre;
    this.edad = edad;
    this.peso = peso;
  }

  @Override
  public String toString() {
    return "Mascota [no_registro=" + no_registro + ", nombre=" + nombre + ", edad=" + edad + ", peso=" + peso
            + "]\n";
  }

  public int getNo_registro() {
    return no_registro;
  }

  public void setNo_registro(int no_registro) {
    this.no_registro = no_registro;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public int getEdad() {
    return edad;
  }

  public void setEdad(int edad) {
    this.edad = edad;
  }

  public double getPeso() {
    return peso;
  }

  public void setPeso(double peso) {
    this.peso = peso;
  }

}
