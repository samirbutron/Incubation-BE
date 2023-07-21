package com.mx.Incubation.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "farmacos")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Farmaco {

  @Id
  @Column(name = "codigo_barras")
  private int id;
  private String nombre;
  private String marca;
  private int stock;
  private double precio;
  @Column(name = "fecha_caducidad")
  private Date caducidad;
  @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
  @JoinTable(
      name = "farmacias_farmacos",
      joinColumns =
      @JoinColumn(name = "farmaco_codigo",
          referencedColumnName = "codigo_barras"
      ),
      inverseJoinColumns =
      @JoinColumn(name = "farmacia_numero",
          referencedColumnName = "numero_sucursal"
      )
  )
  @JsonIgnore
  private List<Farmacia> farmacias = new ArrayList<>();
}
