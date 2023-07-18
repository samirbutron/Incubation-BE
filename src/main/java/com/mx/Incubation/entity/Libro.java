package com.mx.Incubation.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "LIBROS")
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Libro {

  @Id
  @Column
  String folio;
  String titulo;
  String autor;
  String editorial;
  String genero;
  int precio;
  @Column(name = "NO_PAGINAS")
  int paginas;
}