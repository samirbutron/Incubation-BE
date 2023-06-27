package classes;

public class Computadora {
  private String marca;
  private String modelo;
  private int ram;
  private int almacenamiento;
  private double precio;
  private String tipo;
  private double tamañoTorre;

  public Computadora() {
  }

  public Computadora(String marca, String modelo, int ram, int almacenamiento, double precio,
      String tipo, double tamañoTorre) {
    this.marca = marca;
    this.modelo = modelo;
    this.ram = ram;
    this.almacenamiento = almacenamiento;
    this.precio = precio;
    this.tipo = tipo;
    this.tamañoTorre = tamañoTorre;
  }

  public String getMarca() {
    return marca;
  }

  public void setMarca(String marca) {
    this.marca = marca;
  }

  public String getModelo() {
    return modelo;
  }

  public void setModelo(String modelo) {
    this.modelo = modelo;
  }

  public int getRam() {
    return ram;
  }

  public void setRam(int ram) {
    this.ram = ram;
  }

  public int getAlmacenamiento() {
    return almacenamiento;
  }

  public void setAlmacenamiento(int almacenamiento) {
    this.almacenamiento = almacenamiento;
  }

  public double getPrecio() {
    return precio;
  }

  public void setPrecio(double precio) {
    this.precio = precio;
  }

  public String getTipo() {
    return tipo;
  }

  public void setTipo(String tipo) {
    this.tipo = tipo;
  }

  public double getTamañoTorre() {
    return tamañoTorre;
  }

  public void setTamañoTorre(double tamañoTorre) {
    this.tamañoTorre = tamañoTorre;
  }

  @Override
  public String toString() {
    return "Computadora{" +
        "marca='" + marca + '\'' +
        ", modelo='" + modelo + '\'' +
        ", ram=" + ram +
        ", almacenamiento=" + almacenamiento +
        ", precio=" + precio +
        ", tipo='" + tipo + '\'' +
        ", tamañoTorre=" + tamañoTorre +
        '}';
  }
}
