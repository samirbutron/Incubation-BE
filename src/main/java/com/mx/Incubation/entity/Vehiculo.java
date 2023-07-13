package com.mx.Incubation.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "vehiculo")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Vehiculo {

  @Id
  @Column
  private String matricula;
  @Column
  private String marca;
  @Column
  private String modelo;
  @Column
  private String tipo;
  @Column
  private int velocidad;
  @Column
  private int precio;
  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "persona_curp") //Union en base de datos
  private Persona persona;
}
