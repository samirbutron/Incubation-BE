package com.mx.Incubation.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "clientela")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cliente {

  @Id
  private String email;
  private String nombre;
  @Column(name = "apellido_paterno")
  private String apellidoP;
  @Column(name = "apellido_materno")
  private String apellidoM;
  @Column(name = "fecha_nacimiento")
  private Date dob;
  private String nacionalidad;
  @ManyToMany(mappedBy = "clientes")
  @JsonIgnore
  private List<Hotel> hoteles = new ArrayList<>();

  public Cliente(String email) {
    this.email = email;
  }

  public Cliente(String email, String nombre, String apellidoP, String apellidoM, Date dob,
      String nacionalidad) {
    this.email = email;
    this.nombre = nombre;
    this.apellidoP = apellidoP;
    this.apellidoM = apellidoM;
    this.dob = dob;
    this.nacionalidad = nacionalidad;
  }
}
