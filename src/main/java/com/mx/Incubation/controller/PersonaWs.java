package com.mx.Incubation.controller;

import com.mx.Incubation.entity.Persona;
import com.mx.Incubation.response.Respuesta;
import com.mx.Incubation.service.Implementacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("personas")
@CrossOrigin
public class PersonaWs {

  @Autowired
  Implementacion implementacion;

  @GetMapping("listar")
  public Respuesta mostrar() {
    return implementacion.mostrar();
  }

  @PostMapping(value = "guardar")
  public Respuesta guardar(@RequestBody Persona persona) {
    return implementacion.guardar(persona);
  }

  @PostMapping("editar")
  public Respuesta editar(@RequestBody Persona persona) {
    return implementacion.editar(persona);
  }

  @PostMapping("eliminar")
  public Respuesta eliminar(@RequestBody Persona persona) {
    return implementacion.eliminar(persona);
  }

  @GetMapping("buscar")
  public Respuesta buscar(@RequestBody Persona persona) {
    return implementacion.buscar(persona);
  }

  @GetMapping("buscarPorNacionalidad")
  public Respuesta buscarPorNacionalidad(@RequestBody Persona persona) {
    return implementacion.buscarPorNacionalidad(persona);
  }
}
