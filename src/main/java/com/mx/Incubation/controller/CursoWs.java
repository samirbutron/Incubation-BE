package com.mx.Incubation.controller;

import com.mx.Incubation.entity.Curso;
import com.mx.Incubation.peticion.Peticion;
import com.mx.Incubation.response.Respuesta;
import com.mx.Incubation.service.ImpCurso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("curso")
@CrossOrigin
public class CursoWs {

  @Autowired
  ImpCurso impCurso;

  @GetMapping("listar")
  public Respuesta mostrar() {
    return impCurso.mostrar();
  }

  @PostMapping("guardar")
  public Respuesta guardar(@RequestBody Curso curso) {
    return impCurso.guardar(curso);
  }

  @PostMapping("editar")
  public Respuesta editar(@RequestBody Curso curso) {
    return impCurso.editar(curso);
  }

  @PostMapping("eliminar")
  public Respuesta eliminar(@RequestBody Curso curso) {
    return impCurso.eliminar(curso);
  }

  @GetMapping("buscar")
  public Respuesta buscar(@RequestBody Curso curso) {
    return impCurso.buscar(curso);
  }

  @PostMapping("inscripcion")
  public Respuesta inscripcion(@RequestBody Peticion peticion) {
    return impCurso.inscripcion(peticion);
  }
}
