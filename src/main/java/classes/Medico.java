package classes;

import java.util.ArrayList;
import java.util.List;

public class Medico extends Persona{

  private String especialidad;
  private String turno;
  private String seccion;
  private List<Paciente> pacientes = new ArrayList<>();

  public Medico() {
  }

  public Medico(String nombre, String apellido, int edad, String genero, String telefono,
      String especialidad, String turno, String seccion, List<Paciente> pacientes) {
    super(nombre, apellido, edad, genero, telefono);
    this.especialidad = especialidad;
    this.turno = turno;
    this.seccion = seccion;
    this.pacientes = pacientes;
  }

  public Medico(String nombre, String apellido, int edad, String genero, String telefono,
      String especialidad, String turno, String seccion) {
    super(nombre, apellido, edad, genero, telefono);
    this.especialidad = especialidad;
    this.turno = turno;
    this.seccion = seccion;
  }

  public String getEspecialidad() {
    return especialidad;
  }

  public void setEspecialidad(String especialidad) {
    this.especialidad = especialidad;
  }

  public String getTurno() {
    return turno;
  }

  public void setTurno(String turno) {
    this.turno = turno;
  }

  public String getSeccion() {
    return seccion;
  }

  public void setSeccion(String seccion) {
    this.seccion = seccion;
  }

  public List<Paciente> getPacientes() {
    return pacientes;
  }

  public void setPacientes(List<Paciente> pacientes) {
    this.pacientes = pacientes;
  }

  @Override
  public String toString() {
    return super.toString() + ", Medico{" +
        "especialidad='" + especialidad + '\'' +
        ", turno='" + turno + '\'' +
        ", seccion='" + seccion + '\'' +
        ", pacientes=" + pacientes +
        '}';
  }
}
