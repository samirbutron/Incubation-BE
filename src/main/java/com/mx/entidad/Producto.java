package com.mx.entidad;

public class Producto {
  private String codigoBarras;
  private String nombre;
  private String marca;
  private String tipo;
  private int stock;

  public Producto() {
  }

  public Producto(String codigoBarras) {
    this.codigoBarras = codigoBarras;
  }

  public Producto(String codigoBarras, String nombre, String marca, String tipo, int stock) {
    this.codigoBarras = codigoBarras;
    this.nombre = nombre;
    this.marca = marca;
    this.tipo = tipo;
    this.stock = stock;
  }

  public String getCodigoBarras() {
    return codigoBarras;
  }

  public void setCodigoBarras(String codigoBarras) {
    this.codigoBarras = codigoBarras;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getMarca() {
    return marca;
  }

  public void setMarca(String marca) {
    this.marca = marca;
  }

  public String getTipo() {
    return tipo;
  }

  public void setTipo(String tipo) {
    this.tipo = tipo;
  }

  public int getStock() {
    return stock;
  }

  public void setStock(int stock) {
    this.stock = stock;
  }

  @Override
  public String toString() {
    return "Producto{" +
        "codigoBarras='" + codigoBarras + '\'' +
        ", nombre='" + nombre + '\'' +
        ", marca='" + marca + '\'' +
        ", tipo='" + tipo + '\'' +
        ", stock=" + stock +
        '}';
  }
}
