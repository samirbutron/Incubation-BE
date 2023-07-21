package com.mx.Incubation.controller;

import com.mx.Incubation.entity.Farmaco;
import com.mx.Incubation.petition.Petition;
import com.mx.Incubation.response.Respuesta;
import com.mx.Incubation.service.ImpFarmaco;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("farmaco")
@CrossOrigin
public class FarmacoWs {

  @Autowired
  ImpFarmaco impFarmaco;

  @GetMapping("listar")
  public Respuesta listar() {
    return impFarmaco.show();
  }

  @PostMapping("guardar")
  public Respuesta guardar(@RequestBody Farmaco farmaco) {
    return impFarmaco.save(farmaco);
  }

  @PostMapping("editar")
  public Respuesta editar(@RequestBody Farmaco farmaco) {
    return impFarmaco.update(farmaco);
  }

  @PostMapping("buscar")
  public Respuesta buscar(@RequestBody Farmaco farmaco) {
    return impFarmaco.search(farmaco);
  }

  @PostMapping("eliminar")
  public Respuesta eliminar(@RequestBody Farmaco farmaco) {
    return impFarmaco.delete(farmaco);
  }

  @PostMapping("relacionar")
  public Respuesta relacionar(@RequestBody Petition petition) {
    return impFarmaco.createRelationship(petition);
  }

  @PostMapping("desrelacionar")
  public Respuesta desrelacionar(@RequestBody Petition petition) {
    return impFarmaco.deleteRelationship(petition);
  }
}
