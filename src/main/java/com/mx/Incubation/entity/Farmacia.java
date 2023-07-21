package com.mx.Incubation.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "farmacias")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Farmacia {

  @Id
  @Column(name = "numero_sucursal")
  private int id;
  private String ciudad;
  private String colonia;
  private String calle;
  private int numero;
  @ManyToMany(mappedBy = "farmacias")
  @JsonIgnore
  private List<Farmaco> farmacos = new ArrayList<>();

  public Farmacia(int id) {
    this.id = id;
  }

  public Farmacia(int id, String ciudad, String colonia, String calle, int numero) {
    this.id = id;
    this.ciudad = ciudad;
    this.colonia = colonia;
    this.calle = calle;
    this.numero = numero;
  }
}
