package classes;

import java.util.List;
import java.util.Objects;

public class Profesor extends Persona{
  private String materia;
  private double sueldo;
  private List<Alumno> alumnoList;

  public Profesor() {
  }

  public Profesor(String nombre, String apellido, int edad, String materia, double sueldo,
      List<Alumno> alumnoList) {
    super(nombre, apellido, edad);
    this.materia = materia;
    this.sueldo = sueldo;
    this.alumnoList = alumnoList;
  }

  public String getMateria() {
    return materia;
  }

  public void setMateria(String materia) {
    this.materia = materia;
  }

  public double getSueldo() {
    return sueldo;
  }

  public void setSueldo(double sueldo) {
    this.sueldo = sueldo;
  }

  public List<Alumno> getAlumnoList() {
    return alumnoList;
  }

  public void setAlumnoList(List<Alumno> alumnoList) {
    this.alumnoList = alumnoList;
  }

  @Override
  public String toString() {
    return "Profesor{" +
        "materia='" + materia + '\'' +
        ", sueldo=" + sueldo +
        ", alumnoList=" + alumnoList +
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
    Profesor profesor = (Profesor) o;
    return Double.compare(profesor.sueldo, sueldo) == 0 && Objects.equals(materia,
        profesor.materia) && Objects.equals(alumnoList, profesor.alumnoList);
  }
}
