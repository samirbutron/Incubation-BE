package com.mx.Incubation.controller;

import com.mx.Incubation.entity.Hotel;
import com.mx.Incubation.petition.Petition;
import com.mx.Incubation.response.Respuesta;
import com.mx.Incubation.service.ImpHotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("hotel")
@CrossOrigin
public class HotelWs {

  @Autowired
  ImpHotel impClienteGym;

  @GetMapping("listar")
  public Respuesta listar() {
    return impClienteGym.show();
  }

  @PostMapping("guardar")
  public Respuesta guardar(@RequestBody Hotel hotel) {
    return impClienteGym.save(hotel);
  }

  @PostMapping("editar")
  public Respuesta editar(@RequestBody Hotel hotel) {
    System.out.println(hotel);
    return impClienteGym.update(hotel);
  }

  @PostMapping("buscar")
  public Respuesta buscar(@RequestBody Hotel hotel) {
    return impClienteGym.search(hotel);
  }

  @PostMapping("eliminar")
  public Respuesta eliminar(@RequestBody Hotel hotel) {
    return impClienteGym.delete(hotel);
  }

  @PostMapping("relacionar")
  public Respuesta relacionar(@RequestBody Petition petition) {
    return impClienteGym.createRelationship(petition);
  }
}
