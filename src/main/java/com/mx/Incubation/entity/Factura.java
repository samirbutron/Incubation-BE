package com.mx.Incubation.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.sql.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "factura_api")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Factura {

  @Id
  @Column
  private int folio;
  @Column(name = "nombre_de_la_tienda")
  private String nombreTienda;
  @Column
  private Date fecha;
  @Column(name = "total_a_pagar")
  private double total;
  @Column(name = "numero_articulos")
  private int noArticulos;
  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "rfc_cliente") //Union en base de datos
  private Cliente cliente;
}
