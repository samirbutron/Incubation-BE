package com.mx.entidad;

import java.util.ArrayList;
import java.util.List;

public class Tienda {
  private int numeroSucursal;
  private String ciudad;
  private String colonia;
  private String calle;
  private int numero;
  List<Producto> productos = new ArrayList<>();

  public Tienda() {
  }

  public Tienda(int numeroSucursal) {
    this.numeroSucursal = numeroSucursal;
  }

  public Tienda(int numeroSucursal, String ciudad, String colonia, String calle, int numero,
      List<Producto> productos) {
    this.numeroSucursal = numeroSucursal;
    this.ciudad = ciudad;
    this.colonia = colonia;
    this.calle = calle;
    this.numero = numero;
    this.productos = productos;
  }

  public Tienda(int numeroSucursal, String ciudad, String colonia, String calle, int numero) {
    this.numeroSucursal = numeroSucursal;
    this.ciudad = ciudad;
    this.colonia = colonia;
    this.calle = calle;
    this.numero = numero;
  }

  public int getNumeroSucursal() {
    return numeroSucursal;
  }

  public void setNumeroSucursal(int numeroSucursal) {
    this.numeroSucursal = numeroSucursal;
  }

  public String getCiudad() {
    return ciudad;
  }

  public void setCiudad(String ciudad) {
    this.ciudad = ciudad;
  }

  public String getColonia() {
    return colonia;
  }

  public void setColonia(String colonia) {
    this.colonia = colonia;
  }

  public String getCalle() {
    return calle;
  }

  public void setCalle(String calle) {
    this.calle = calle;
  }

  public int getNumero() {
    return numero;
  }

  public void setNumero(int numero) {
    this.numero = numero;
  }

  public List<Producto> getProductos() {
    return productos;
  }

  public void setProductos(List<Producto> productos) {
    this.productos = productos;
  }

  @Override
  public String toString() {
    return "Tienda{" +
        "numeroSucursal=" + numeroSucursal +
        ", ciudad='" + ciudad + '\'' +
        ", colonia='" + colonia + '\'' +
        ", calle='" + calle + '\'' +
        ", numero=" + numero +
        ", productos=" + productos +
        '}';
  }
}
