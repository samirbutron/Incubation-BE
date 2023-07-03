package com.mx.entidad;

import java.util.ArrayList;
import java.util.List;

public class Curso {

  private String nombre;
  private String categoria;
  private int creditos;
  private int horas;
  private List<Alumno> alumnos = new ArrayList<>();

  public Curso() {
  }

  public Curso(String nombre, String categoria, int creditos, int horas) {
    this.nombre = nombre;
    this.categoria = categoria;
    this.creditos = creditos;
    this.horas = horas;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getCategoria() {
    return categoria;
  }

  public void setCategoria(String categoria) {
    this.categoria = categoria;
  }

  public int getCreditos() {
    return creditos;
  }

  public void setCreditos(int creditos) {
    this.creditos = creditos;
  }

  public int getHoras() {
    return horas;
  }

  public void setHoras(int horas) {
    this.horas = horas;
  }

  public List<Alumno> getAlumnos() {
    return alumnos;
  }

  public void setAlumnos(List<Alumno> alumnos) {
    this.alumnos = alumnos;
  }

  @Override
  public String toString() {
    return "Curso{" +
        "nombre='" + nombre + '\'' +
        ", categoria='" + categoria + '\'' +
        ", creditos=" + creditos +
        ", horas=" + horas +
        ", alumnos=" + alumnos +
        '}';
  }
}
