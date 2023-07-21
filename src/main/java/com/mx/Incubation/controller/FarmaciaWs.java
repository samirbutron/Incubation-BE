package com.mx.Incubation.controller;

import com.mx.Incubation.entity.Farmacia;
import com.mx.Incubation.response.Respuesta;
import com.mx.Incubation.service.ImpFarmacia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("farmacia")
@CrossOrigin
public class FarmaciaWs {

  @Autowired
  ImpFarmacia impFarmacia;

  @GetMapping("listar")
  public Respuesta listar() {
    return impFarmacia.show();
  }

  @PostMapping("guardar")
  public Respuesta guardar(@RequestBody Farmacia farmacia) {
    return impFarmacia.save(farmacia);
  }

  @PostMapping("editar")
  public Respuesta editar(@RequestBody Farmacia farmacia) {
    return impFarmacia.update(farmacia);
  }

  @PostMapping("buscar")
  public Respuesta buscar(@RequestBody Farmacia farmacia) {
    return impFarmacia.search(farmacia);
  }

  @PostMapping("eliminar")
  public Respuesta eliminar(@RequestBody Farmacia farmacia) {
    return impFarmacia.delete(farmacia);
  }
}
