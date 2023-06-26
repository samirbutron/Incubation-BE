package classes;

public class Auto {

  private String color;
  private String marca;
  private double peso;
  private String tipo;
  private int velocidad;

  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }

  public String getMarca() {
    return marca;
  }

  public void setMarca(String marca) {
    this.marca = marca;
  }

  public double getPeso() {
    return peso;
  }

  public void setPeso(double peso) {
    this.peso = peso;
  }

  public String getTipo() {
    return tipo;
  }

  public void setTipo(String tipo) {
    this.tipo = tipo;
  }

  public int getVelocidad() {
    return velocidad;
  }

  public void setVelocidad(int velocidad) {
    this.velocidad = velocidad;
  }

  @Override
  public String toString() {
    return "Auto{" +
        "color='" + color + '\'' +
        ", marca='" + marca + '\'' +
        ", peso=" + peso +
        ", tipo='" + tipo + '\'' +
        ", velocidad=" + velocidad +
        '}';
  }
}
