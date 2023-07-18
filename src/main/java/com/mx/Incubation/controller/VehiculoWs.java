package com.mx.Incubation.controller;

import com.mx.Incubation.entity.Vehiculo;
import com.mx.Incubation.response.Respuesta;
import com.mx.Incubation.service.ImpVehiculo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("vehiculo")
@CrossOrigin
public class VehiculoWs {

  @Autowired
  ImpVehiculo impVehiculo;

  @GetMapping("listar")
  public Respuesta mostrar() {
    return impVehiculo.mostrar();
  }

  @PostMapping("guardar")
  public Respuesta guardar(@RequestBody Vehiculo vehiculo) {
    return impVehiculo.guardar(vehiculo);
  }

  @PostMapping("editar")
  public Respuesta editar(@RequestBody Vehiculo vehiculo) {
    return impVehiculo.editar(vehiculo);
  }

  @PostMapping("eliminar")
  public Respuesta eliminar(@RequestBody Vehiculo vehiculo) {
    return impVehiculo.eliminar(vehiculo);
  }

  @PostMapping("buscar")
  public Respuesta buscar(@RequestBody Vehiculo vehiculo) {
    return impVehiculo.buscar(vehiculo);
  }
}
