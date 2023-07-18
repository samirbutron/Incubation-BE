package com.mx.Incubation.controller;

import com.mx.Incubation.entity.Libro;
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
@RequestMapping("libros")
@CrossOrigin
public class LibrosWs {

  @Autowired
  Implementacion implementacion;

  @GetMapping("listar")
  public Respuesta mostrar() {
    return implementacion.mostrar();
  }

  @PostMapping("guardar")
  public Respuesta guardar(@RequestBody Libro libro) {
    return implementacion.guardar(libro);
  }

  @PostMapping("editar")
  public Respuesta editar(@RequestBody Libro libro) {
    return implementacion.editar(libro);
  }

  @PostMapping("eliminar")
  public Respuesta eliminar(@RequestBody Libro libro) {
    return implementacion.eliminar(libro);
  }

  @PostMapping("buscar")
  public Respuesta buscar(@RequestBody Libro libro) {
    return implementacion.buscar(libro);
  }
}
