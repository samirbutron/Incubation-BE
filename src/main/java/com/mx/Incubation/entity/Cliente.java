package com.mx.Incubation.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "clientes_api")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {

  @Id
  @Column
  private String rfc;
  @Column
  private String nombre;
  @Column
  private String apellido;
  @Column
  private String ciudad;
  @Column(name = "fecha_nacimiento")
  //La peticion HTTP debe tener estos campos, como se escriben aqui
  private Date fechaNacimiento;
  @OneToMany(mappedBy = "cliente", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  //mappedBy apunta al objeto persona dentro de Vehiculo.class
  @JsonIgnore
  private List<Factura> facturas = new ArrayList<>();
}
