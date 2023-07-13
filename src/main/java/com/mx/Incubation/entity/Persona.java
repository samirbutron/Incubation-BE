package com.mx.Incubation.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "persona")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Persona {

  @Id
  @Column
  private String curp;
  @Column
  private String nombre;
  @Column
  private String apellido;
  @Column
  private String ciudad;
  @Column
  private int edad;
  @OneToMany(mappedBy = "persona", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  //mappedBy apunta al objeto persona dentro de Vehiculo.class
  @JsonIgnore
  private List<Vehiculo> vehiculos = new ArrayList<>();
}
