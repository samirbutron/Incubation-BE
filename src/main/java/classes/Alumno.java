package classes;

import java.util.Objects;

public class Alumno extends Persona{
  private double promedio;
  private int grado;
  private String grupo;
  private int materias;

  public Alumno(){
    super();
  }

  public Alumno(String nombre, String apellido, int edad, double promedio, int grado, String grupo,
      int materias) {
    super(nombre, apellido, edad);
    this.promedio = promedio;
    this.grado = grado;
    this.grupo = grupo;
    this.materias = materias;
  }

  public double getPromedio() {
    return promedio;
  }

  public void setPromedio(double promedio) {
    this.promedio = promedio;
  }

  public int getGrado() {
    return grado;
  }

  public void setGrado(int grado) {
    this.grado = grado;
  }

  public String getGrupo() {
    return grupo;
  }

  public void setGrupo(String grupo) {
    this.grupo = grupo;
  }

  public int getMaterias() {
    return materias;
  }

  public void setMaterias(int materias) {
    this.materias = materias;
  }

  @Override
  public String toString() {
    return "Alumno{" +
        "promedio=" + promedio +
        ", grado=" + grado +
        ", grupo='" + grupo + '\'' +
        ", materias=" + materias +
        '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Alumno alumno = (Alumno) o;
    return Double.compare(alumno.promedio, promedio) == 0 && grado == alumno.grado
        && materias == alumno.materias && Objects.equals(grupo, alumno.grupo);
  }
}
