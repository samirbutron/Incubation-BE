package com.mx.Incubation.dto;

import com.mx.Incubation.entity.Cliente;
import com.mx.Incubation.entity.Hotel;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//GymDto needed to populate the list of clients
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteDto {

  private String email;
  private String nombre;
  private String apellidoP;
  private String apellidoM;
  private Date dob;
  private String nacionalidad;
  private List<Hotel> hoteles = new ArrayList<>();

  public ClienteDto(Cliente cliente) {
    this.email = cliente.getEmail();
    this.nombre = cliente.getNombre();
    this.apellidoP = cliente.getApellidoP();
    this.apellidoM = cliente.getApellidoM();
    this.dob = cliente.getDob();
    this.nacionalidad = cliente.getNacionalidad();
    this.hoteles = cliente.getHoteles();
  }
}
