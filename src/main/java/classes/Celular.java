package classes;

public class Celular {
  String marca;
  String modelo;
  int precio;
  double tamaño;
  int almacenamiento;

  public Celular() {
  }

  public Celular(String marca, String modelo, int precio, double tamaño, int almacenamiento) {
    this.marca = marca;
    this.modelo = modelo;
    this.precio = precio;
    this.tamaño = tamaño;
    this.almacenamiento = almacenamiento;

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

  public int getPrecio() {
    return precio;
  }

  public void setPrecio(int precio) {
    this.precio = precio;
  }

  public double getTamaño() {
    return tamaño;
  }

  public void setTamaño(double tamaño) {
    this.tamaño = tamaño;
  }

  public int getAlmacenamiento() {
    return almacenamiento;
  }

  public void setAlmacenamiento(int almacenamiento) {
    this.almacenamiento = almacenamiento;
  }

  @Override
  public String toString() {
    return "Celular{" +
        "marca='" + marca + '\'' +
        ", modelo='" + modelo + '\'' +
        ", precio=" + precio +
        ", tamaño=" + tamaño +
        ", almacenamiento=" + almacenamiento +
        '}';
  }
}
