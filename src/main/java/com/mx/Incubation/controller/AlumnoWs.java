package com.mx.Incubation.controller;

import com.mx.Incubation.entity.Alumno;
import com.mx.Incubation.response.Respuesta;
import com.mx.Incubation.service.ImpAlumno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("alumno")
@CrossOrigin
public class AlumnoWs {

  @Autowired
  ImpAlumno impAlumno;

  @GetMapping("listar")
  public Respuesta mostrar() {
    return impAlumno.mostrar();
  }

  @PostMapping("guardar")
  public Respuesta guardar(@RequestBody Alumno alumno) {
    return impAlumno.guardar(alumno);
  }

  @PostMapping("editar")
  public Respuesta editar(@RequestBody Alumno alumno) {
    return impAlumno.editar(alumno);
  }

  @PostMapping("eliminar")
  public Respuesta eliminar(@RequestBody Alumno alumno) {
    return impAlumno.eliminar(alumno);
  }

  @GetMapping("buscar")
  public Respuesta buscar(@RequestBody Alumno alumno) {
    return impAlumno.buscar(alumno);
  }
}
