package com.mx.entidad;

public class Mascota {
  private String nombre;
  private int edad;
  private double peso;
  private String especie;

  public Mascota() {
  }

  //Llave de esta clase
  public Mascota(String nombre) {
    this.nombre = nombre;
  }

  public Mascota(String nombre, int edad, double peso, String especie) {
    this.nombre = nombre;
    this.edad = edad;
    this.peso = peso;
    this.especie = especie;
  }

  public String getNombre() {
    return nombre;
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

  public String getEspecie() {
    return especie;
  }

  public void setEspecie(String especie) {
    this.especie = especie;
  }

  @Override
  public String toString() {
    return "Mascota{" +
        "nombre='" + nombre + '\'' +
        ", edad='" + edad + '\'' +
        ", peso=" + peso +
        ", especie='" + especie + '\'' +
        '}';
  }
}
