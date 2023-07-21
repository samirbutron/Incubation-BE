package com.mx.Incubation.dto;

import com.mx.Incubation.entity.Farmacia;
import com.mx.Incubation.entity.Farmaco;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//FarmacoDto needed to populate the list of farmacias
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FarmacoDto {

  private int id;
  private String nombre;
  private String marca;
  private int stock;
  private double precio;
  private Date caducidad;
  private List<Farmacia> farmacias = new ArrayList<>();

  public FarmacoDto(Farmaco client) {
    this.id = client.getId();
    this.nombre = client.getNombre();
    this.marca = client.getMarca();
    this.stock = client.getStock();
    this.precio = client.getPrecio();
    this.caducidad = client.getCaducidad();
    this.farmacias = client.getFarmacias();
  }
}
