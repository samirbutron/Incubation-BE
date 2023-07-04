package com.mx.entidad;

import java.util.Date;

public abstract class Producto {

  private String nombre;
  private String marca;
  private int stock;
  private double precio;

  public Producto() {
  }

  public Producto(String nombre, String marca, int stock, double precio) {
    this.nombre = nombre;
    this.marca = marca;
    this.stock = stock;
    this.precio = precio;
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

  public int getStock() {
    return stock;
  }

  public void setStock(int stock) {
    this.stock = stock;
  }

  public double getPrecio() {
    return precio;
  }

  public void setPrecio(double precio) {
    this.precio = precio;
  }

  @Override
  public String toString() {
    return "Producto{" +
        "nombre='" + nombre + '\'' +
        ", marca='" + marca + '\'' +
        ", stock=" + stock +
        ", precio=" + precio +
        '}';
  }

  public abstract double precioImpuesto();
}
