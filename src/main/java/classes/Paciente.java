package classes;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Paciente extends Persona{
  private List<String> padecimientos = new ArrayList<>();
  private List<String> alergias = new ArrayList<>();
  private String nss;

  public Paciente() {
  }

  public Paciente(String nombre, String apellido, int edad, String genero,String telefono, String nss) {
    super(nombre, apellido, edad, genero, telefono);
    this.nss = nss;
  }

  public Paciente(String nombre, String apellido, int edad, String genero, String telefono,
      List<String> padecimientos, List<String> alergias, String nss) {
    super(nombre, apellido, edad, genero, telefono);
    this.padecimientos = padecimientos;
    this.alergias = alergias;
    this.nss = nss;
  }

  public List<String> getPadecimientos() {
    return padecimientos;
  }

  public void setPadecimientos(List<String> padecimientos) {
    this.padecimientos = padecimientos;
  }

  public List<String> getAlergias() {
    return alergias;
  }

  public void setAlergias(List<String> alergias) {
    this.alergias = alergias;
  }

  public String getNss() {
    return nss;
  }

  public void setNss(String nss) {
    this.nss = nss;
  }

  @Override
  public String toString() {
    return super.toString() + ", Paciente{" +
        "padecimientos=" + padecimientos +
        ", alergias=" + alergias +
        ", nss='" + nss + '\'' +
        "} ";
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Paciente paciente = (Paciente) o;
    return Objects.equals(padecimientos, paciente.padecimientos)
        && Objects.equals(alergias, paciente.alergias) && Objects.equals(nss,
        paciente.nss);
  }
}
