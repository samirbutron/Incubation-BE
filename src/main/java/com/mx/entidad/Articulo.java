package com.mx.entidad;

import java.util.Date;

public class Articulo extends Producto {

  private String color;
  private String material;

  public Articulo() {
  }

  public Articulo(String nombre, String marca, int stock, double precio, String color,
      String material) {
    super(nombre, marca, stock, precio);
    this.color = color;
    this.material = material;
  }

  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }

  public String getMaterial() {
    return material;
  }

  public void setMaterial(String material) {
    this.material = material;
  }

  @Override
  public String toString() {
    return "Articulo{" +
        "color='" + color + '\'' +
        ", material='" + material + '\'' +
        "} " + super.toString();
  }

  @Override
  public double precioImpuesto() {
    return getPrecio() + (getPrecio()*0.10);
  }
}
