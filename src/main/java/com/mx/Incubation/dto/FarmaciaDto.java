package com.mx.Incubation.dto;

import com.mx.Incubation.entity.Farmacia;
import com.mx.Incubation.entity.Farmaco;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//FarmaciaDto needed to populate the list of farmacos
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FarmaciaDto {

  private int id;
  private String ciudad;
  private String colonia;
  private String calle;
  private int numero;
  private List<Farmaco> farmacos = new ArrayList<>();

  public FarmaciaDto(Farmacia farmacia) {
    this.id = farmacia.getId();
    this.ciudad = farmacia.getCiudad();
    this.colonia = farmacia.getColonia();
    this.calle = farmacia.getCalle();
    this.numero = farmacia.getNumero();
    this.farmacos = farmacia.getFarmacos();
  }
}
