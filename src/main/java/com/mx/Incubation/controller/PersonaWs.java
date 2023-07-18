package com.mx.Incubation.controller;

import com.mx.Incubation.entity.Persona;
import com.mx.Incubation.response.Respuesta;
import com.mx.Incubation.service.ImpPersona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("persona")
@CrossOrigin
public class PersonaWs {

  @Autowired
  ImpPersona impPersona;

  @GetMapping("listar")
  public Respuesta mostrar() {
    return impPersona.mostrar();
  }

  @PostMapping("guardar")
  public Respuesta guardar(@RequestBody Persona persona) {
    return impPersona.guardar(persona);
  }

  @PostMapping("editar")
  public Respuesta editar(@RequestBody Persona persona) {
    return impPersona.editar(persona);
  }

  @PostMapping("eliminar")
  public Respuesta eliminar(@RequestBody Persona persona) {
    return impPersona.eliminar(persona);
  }

  @PostMapping("buscar")
  public Respuesta buscar(@RequestBody Persona persona) {
    return impPersona.buscar(persona);
  }
}
