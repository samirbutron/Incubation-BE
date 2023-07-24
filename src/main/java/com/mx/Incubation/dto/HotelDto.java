package com.mx.Incubation.dto;

import com.mx.Incubation.entity.Cliente;
import com.mx.Incubation.entity.Hotel;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//GymClientDto needed to populate the list of gym
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HotelDto {

  private int numeroSucursal;
  private String ciudad;
  private String estado;
  private String colonia;
  private String calle;
  private int numero;
  private int codigoPostal;
  private List<Cliente> clientes;

  public HotelDto(Hotel hotel) {
    this.numeroSucursal = hotel.getNumeroSucursal();
    this.ciudad = hotel.getCiudad();
    this.estado = hotel.getEstado();
    this.colonia = hotel.getColonia();
    this.calle = hotel.getCalle();
    this.numero = hotel.getNumero();
    this.codigoPostal = hotel.getCodigoPostal();
    this.clientes = hotel.getClientes();
  }
}
