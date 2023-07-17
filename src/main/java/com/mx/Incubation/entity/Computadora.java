package com.mx.Incubation.entity;

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
@Table(name = "computadora")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Computadora {

  @Id
  @Column(name = "direccion_mac")
  private String direccionMac;
  private String marca;
  private int almacenamiento;
  private int ram;
  private String tipo;
  private String gama;
  @ManyToMany(mappedBy = "computadoras") //objeto lista en clase Hardware
  private List<Hardware> hardware = new ArrayList<>();
}
