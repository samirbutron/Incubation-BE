package classes;

public class Animal {

  String reino;
  String genero;
  double peso;
  String alimentacion;

  public Animal(String reino, String genero, double peso, String alimentacion) {
    this.reino = reino;
    this.genero = genero;
    this.peso = peso;
    this.alimentacion = alimentacion;
  }

  public Animal() {
  }

  public String getReino() {
    return reino;
  }

  public void setReino(String reino) {
    this.reino = reino;
  }

  public String getGenero() {
    return genero;
  }

  public void setGenero(String genero) {
    this.genero = genero;
  }

  public double getPeso() {
    return peso;
  }

  public void setPeso(double peso) {
    this.peso = peso;
  }

  public String getAlimentacion() {
    return alimentacion;
  }

  public void setAlimentacion(String alimentacion) {
    this.alimentacion = alimentacion;
  }

  @Override
  public String toString() {
    return "Animal{" +
        "reino='" + reino + '\'' +
        ", genero='" + genero + '\'' +
        ", peso='" + peso + '\'' +
        ", alimentacion='" + alimentacion + '\'' +
        '}';
  }
}
