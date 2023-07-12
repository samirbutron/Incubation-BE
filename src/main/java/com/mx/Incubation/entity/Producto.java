package com.mx.Incubation.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "PRODUCTOS")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Producto {

  @Id
  private int codigo;
  private String nombre;
  private String marca;
  private double precio;
  @Column(name = "precio_publico")
  private double precioPublico;
  private int stock;
}
