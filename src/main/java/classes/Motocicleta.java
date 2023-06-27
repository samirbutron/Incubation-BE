package classes;

public class Motocicleta {
  private String marca;
  private int velocidad;
  private String tipo;
  private double peso;

  public Motocicleta() {
  }

  public Motocicleta(String marca, int velocidad, String tipo, double peso) {
    this.marca = marca;
    this.velocidad = velocidad;
    this.tipo = tipo;
    this.peso = peso;
  }

  public String getMarca() {
    return marca;
  }

  public void setMarca(String marca) {
    this.marca = marca;
  }

  public int getVelocidad() {
    return velocidad;
  }

  public void setVelocidad(int velocidad) {
    this.velocidad = velocidad;
  }

  public String getTipo() {
    return tipo;
  }

  public void setTipo(String tipo) {
    this.tipo = tipo;
  }

  public double getPeso() {
    return peso;
  }

  public void setPeso(double peso) {
    this.peso = peso;

  }

  @Override
  public String toString() {
    return "Motocicleta{" +
        "marca='" + marca + '\'' +
        ", velocidad=" + velocidad +
        ", tipo='" + tipo + '\'' +
        ", peso=" + peso +
        '}';
  }
}
