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
@Table(name = "hotel")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Hotel {

  @Id
  @Column(name = "numero_sucursal")
  private int numeroSucursal;
  private String ciudad;
  private String estado;
  private String colonia;
  private String calle;
  private int numero;
  @Column(name = "codigo_postal")
  private int codigoPostal;
  @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
  @JoinTable(
      name = "clientela_hotel",
      joinColumns =
      @JoinColumn(name = "hotel_numero",
          referencedColumnName = "numero_sucursal"
      ),
      inverseJoinColumns =
      @JoinColumn(name = "cliente_email",
          referencedColumnName = "email"
      )
  )
  @JsonIgnore
  private List<Cliente> clientes = new ArrayList<>();
}
