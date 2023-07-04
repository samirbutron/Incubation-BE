package com.mx.entidad;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Consumible extends Producto {

  private Date caducidad;
  private String tipo;
  private String sabor;

  public Consumible() {
  }

  public Consumible(String nombre, String marca, int stock, double precio, String caducidad, String tipo, String sabor) {
    super(nombre, marca, stock, precio);
    SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
    try {
      this.caducidad = formatoFecha.parse(caducidad);
    } catch (ParseException e) {
      System.out.println("El formato del string para caducidad no es valido");
    }
    this.tipo = tipo;
    this.sabor = sabor;
  }

  public Date getCaducidad() {
    return caducidad;
  }

  public void setCaducidad(String caducidad) {
    SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
    try {
      this.caducidad = formatoFecha.parse(caducidad);
    } catch (ParseException e) {
      System.out.println("El formato del string para caducidad no es valido");
    }
  }

  public String getTipo() {
    return tipo;
  }

  public void setTipo(String tipo) {
    this.tipo = tipo;
  }

  public String getSabor() {
    return sabor;
  }

  public void setSabor(String sabor) {
    this.sabor = sabor;
  }

  @Override
  public String toString() {
    SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MMMM/yyyy");
    return "Consumible{" +
        "caducidad=" + formatoFecha.format(caducidad) +
        ", tipo='" + tipo + '\'' +
        ", sabor='" + sabor + '\'' +
        "} " + super.toString();
  }

  @Override
  public double precioImpuesto() {
    return getPrecio() + (getPrecio()*0.10);
  }
}
