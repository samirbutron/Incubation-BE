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
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "hardware")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Hardware {

  @Id
  @Column(name = "numero_serie")
  private int numeroSerie;
  @Column(name = "nombre_del_componente")
  private String nombreComponente;
  private String marca;
  private String gama;
  private String caracteristica;
  private int precio;
  @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
  @JoinTable(
      name = "computadora_hardware", //tabla en DB de llaves foraneas
      joinColumns =
          //Este mapeo de columna tiene que ser la misma de la clase en la que estamos
      @JoinColumn(name = "serie_hardware" //nombre de columna con llave foranea en DB
          , referencedColumnName = "numero_serie" //nombre de columna en DB con llave primaria que referencia la llave foranea de arriba
      ),
      inverseJoinColumns =
      @JoinColumn(name = "mac_computadora", //nombre de la otra columna con llave foranea en DB
          referencedColumnName = "direccion_mac" //nombre de columna que tiene es la llave primaria que referencia la llave foranea de arriba
      )
  )
  @JsonIgnore
  private List<Computadora> computadoras = new ArrayList<>();
}
